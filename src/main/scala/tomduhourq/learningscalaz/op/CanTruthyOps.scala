package tomduhourq.learningscalaz.op

import tomduhourq.learningscalaz.truthy.CanTruthy
import scala.language.implicitConversions

/**
 * Trait to inject truthy methods to whichever
 * type has an implicit CanTruthy instance.
 */
trait CanTruthyOps[A] {
  def self: A
  implicit def F: CanTruthy[A]
  final def truthy: Boolean = F.truthys(self)
}

object ToCanIsTruthyOps {
  implicit def toCanTruthyOps[A](v: A)(implicit ev: CanTruthy[A]) =
    new CanTruthyOps[A] {
      def self = v
      implicit def F: CanTruthy[A] = ev
    }

  def truthyIf[A : CanTruthy, B, C](cond: A)(ifyes: => B)(ifno: => C) =
    if (cond.truthy) ifyes
    else ifno
}