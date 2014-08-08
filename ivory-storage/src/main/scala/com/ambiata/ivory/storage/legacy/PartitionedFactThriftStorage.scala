package com.ambiata.ivory.storage.legacy

import com.ambiata.ivory.storage.fact.{FactsetVersionTwo, FactsetVersion, FactsetVersionOne}

import scalaz.{DList => _, Value => _, _}, Scalaz._
import com.nicta.scoobi.Scoobi._
import org.apache.hadoop.io.compress.CompressionCodec
import org.apache.hadoop.fs.Path
import com.ambiata.mundane.io._

import com.ambiata.ivory.core._
import com.ambiata.ivory.core.thrift._
import com.ambiata.ivory.storage.repository.Repository
import com.ambiata.ivory.storage.fact.FactsetGlob
import com.ambiata.poacher.scoobi._
import com.ambiata.ivory.scoobi._
import FactFormats._

import java.net.URI

trait PartitionFactThriftStorage {
  val parsePartition: String => ParseError \/ Partition = scalaz.Memo.mutableHashMapMemo { path: String =>
    Partition.parseFile(FilePath(path)).leftMap(ParseError.withLine(path)).disjunction
  }

  def parseFact(path: String, tfact: ThriftFact): ParseError \/ Fact =
    parsePartition(path).map(p => createFact(p, tfact))

  def createFact(partition: Partition, tfact: ThriftFact): Fact =
    FatThriftFact(partition.namespace, partition.date, tfact)

  def loadScoobiWith(repo: Repository, factset: FactsetId, from: Option[Date], to: Option[Date]): ScoobiAction[DList[ParseError \/ Fact]] = for {
    glob  <- ScoobiAction.fromResultTIO((from, to) match {
               case (Some(f), Some(t)) => FactsetGlob.between(repo, factset, f, t)
               case (Some(f), None)    => FactsetGlob.after(repo, factset, f)
               case (None, Some(t))    => FactsetGlob.before(repo, factset, t)
               case (None, None)       => FactsetGlob.select(repo, factset)
             })
    dlist <- loadScoobiFromPaths(glob.paths)
  } yield dlist

  def loadScoobiFromPaths(paths: List[FilePath]): ScoobiAction[DList[ParseError \/ Fact]] =
    ScoobiAction.scoobiJob({ implicit sc: ScoobiConfiguration =>
      if(paths.nonEmpty)
        valueFromSequenceFileWithPaths[ThriftFact](paths.map(_.path).toSeq).map({ case (path, tfact) => parseFact(path, tfact) })
      else
        DList[ParseError \/ Fact]()
    })

  case class PartitionedFactThriftLoader(repo: Repository, factset: FactsetId, from: Option[Date] = None, to: Option[Date] = None) {
    def loadScoobi: ScoobiAction[DList[ParseError \/ Fact]] =
      loadScoobiWith(repo, factset, from, to)
  }

  case class PartitionedMultiFactsetThriftLoader(repo: Repository, factsets: List[PrioritizedFactset], from: Option[Date] = None, to: Option[Date] = None) {
    def loadScoobi: ScoobiAction[DList[ParseError \/ (Priority, FactsetId, Fact)]] =
      factsets.traverseU(pfs =>
        loadScoobiWith(repo, pfs.factsetId, from, to).map(_.map(_.map((pfs.priority, pfs.factsetId, _))))
      ).map(_.foldLeft(DList[ParseError \/ (Priority, FactsetId, Fact)]())(_ ++ _))
  }

  val partitionPath: ((String, Date)) => String = scalaz.Memo.mutableHashMapMemo { nsd =>
    Partition.stringPath(nsd._1, nsd._2)
  }

  case class PartitionedFactThriftStorer(base: String, codec: Option[CompressionCodec]) extends IvoryScoobiStorer[Fact, DList[(PartitionKey, ThriftFact)]] {
    def storeScoobi(dlist: DList[Fact])(implicit sc: ScoobiConfiguration): DList[(PartitionKey, ThriftFact)] = {
      val partitioned = dlist.by(f => partitionPath((f.namespace, f.date)))
                             .mapValues((f: Fact) => f.toThrift)
                             .valueToPartitionedSequenceFile[PartitionKey, ThriftFact](base, identity, overwrite = true)
      codec.map(partitioned.compressWith(_)).getOrElse(partitioned)
    }
  }
}

object PartitionFactThriftStorageV1 extends PartitionFactThriftStorage
object PartitionFactThriftStorageV2 extends PartitionFactThriftStorage

object PartitionFactThriftStorage {
  def parseThriftFact(factsetVersion: FactsetVersion, path: String)(tfact: ThriftFact): ParseError \/ Fact =
    factsetVersion match {
      case FactsetVersionOne => PartitionFactThriftStorageV1.parseFact(path, tfact)
      case FactsetVersionTwo => PartitionFactThriftStorageV2.parseFact(path, tfact)
    }
}
