package tomduhourq.learningscalaz.op

import tomduhourq.learningscalaz.monoid.Monoid
import scala.language.implicitConversions

trait OptionOp[A] {
  val opt: Option[A]
}

object OptionOp {

  // This is the part of enriching my library
  implicit class MyEnrichedAs[A](val value: A) extends AnyVal {
    def some = Some(value)
  }

  implicit class MyEnrichedOption[+A](val opt: Option[A]) extends AnyVal {
    def |[B >: A](default: => B) = opt getOrElse default
    def unary_~[A : Monoid] = |(implicitly[Monoid[A]].mzero)
  }

  def none[A]: Option[A] = None

  // Implicit conversion so any A can have the OptionOp methods available.
  implicit def toOptionOp[A](value: A) = new OptionOp[A] {
    val opt = Option(value)
  }
}