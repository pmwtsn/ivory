package com.ambiata.ivory.ingest

import org.specs2._
import org.specs2.matcher.FileMatchers
import scalaz.{DList => _, _}, Scalaz._, \&/._
import org.joda.time.{DateTimeZone, LocalDate}
import com.nicta.scoobi.Scoobi._
import com.nicta.scoobi.testing.mutable._
import com.nicta.scoobi.testing.TestFiles._
import com.nicta.scoobi.testing.{TempFiles, SimpleJobs}
import java.io.File
import java.net.URI
import org.apache.hadoop.fs.Path
import com.ambiata.mundane.parse.ListParser
import com.ambiata.mundane.testing.ResultTIOMatcher._

import com.ambiata.ivory.core._
import com.ambiata.ivory.storage.IvoryStorage._
import com.ambiata.ivory.scoobi.WireFormats._
import com.ambiata.mundane.io._

class EavtTextImporterSpec extends HadoopSpecification with SimpleJobs with FileMatchers {
  override def isCluster = false

  "Scoobi job runs and creates expected data" >> { implicit sc: ScoobiConfiguration =>
    implicit val fs = sc.fileSystem

    // create a repository
    val directory = path(TempFiles.createTempDir("eavtimporter").getPath)
    val input = directory + "/input"
    val repository = Repository.fromHdfsPath(new Path(directory, "repo"))
    val errors = new Path(directory, "errors")

    // create a dictionary
    val dict = Dictionary("dict",
      Map(FeatureId("ns1", "fid1") -> FeatureMeta(StringEncoding, CategoricalType, "abc"),
          FeatureId("ns1", "fid2") -> FeatureMeta(IntEncoding, NumericalType, "def"),
          FeatureId("ns1", "fid3") -> FeatureMeta(DoubleEncoding, NumericalType, "ghi")))

    // save input file
    val raw = List("pid1|fid1|v1|2012-10-01 00:00:10",
                   "pid1|fid2|2|2012-10-15 00:00:20",
                   "pid1|fid3|3.0|2012-03-20 00:00:30")

    TempFiles.writeLines(new File(input), raw, isRemote)

    // run the scoobi job to import facts on Hdfs
    EavtTextImporter.onHdfs(repository, dict, "factset1", "ns1", new Path(input), errors, DateTimeZone.getDefault).run(sc) must beOk

    val expected = List(
      StringFact("pid1", FeatureId("ns1", "fid1"), new LocalDate(2012, 10, 1), 10, "v1"),
      IntFact("pid1", FeatureId("ns1", "fid2"), new LocalDate(2012, 10, 15), 20, 2),
      DoubleFact("pid1", FeatureId("ns1", "fid3"), new LocalDate(2012, 3, 20), 30, 3.0))

    (for {
      dl <- factsFromIvoryFactset(repository, "factset1").run(sc).run.unsafePerformIO().toEither
      r  <- dl.run.toList.sequenceU.toEither.leftMap[These[String, Throwable]](This(_))
    } yield r) must beRight((l: List[Fact]) => l must containTheSameElementsAs(expected))
  }
}
