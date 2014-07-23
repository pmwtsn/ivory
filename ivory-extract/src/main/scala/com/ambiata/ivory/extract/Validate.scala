package com.ambiata.ivory.extract

import scalaz.{Value => _, _}, Scalaz._
import com.ambiata.ivory.core._

object Validate {
  def validateFact(fact: Fact, dict: Dictionary): Validation[String, Fact] =
    dict.meta.get(fact.featureId)
      .map {fm => validateEncoding(fact.value, fm.encoding).map(_ => fact).leftMap(_ + s" '${fact.toString}'")}
      .getOrElse(s"Dictionary entry '${fact.featureId}' doesn't exist!".failure)

  def validateEncoding(value: Value, encoding: Encoding): Validation[String, Unit] =
    (value, encoding) match {
      case (BooleanValue(_), BooleanEncoding)   => Success(())
      case (IntValue(_),     IntEncoding)       => Success(())
      case (LongValue(_),    LongEncoding)      => Success(())
      case (DoubleValue(_),  DoubleEncoding)    => Success(())
      case (StringValue(_),  StringEncoding)    => Success(())
      case _                                    => s"Not a valid ${Encoding.render(encoding)}!".failure
    }
}
