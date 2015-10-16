package tomduhourq.learningscalaz.monoidop

import tomduhourq.learningscalaz.monoid.Monoid

/** We would like to provide an operator.
  * But we don’t want to enrich just one type,
  * but enrich all types that have an instance of Monoid available.
  */
trait MonoidOp[A] {
  val F: Monoid[A]
  val value: A
  def |+|(a2: A) = F.mappend(value, a2)
}

object MonoidOp {
  /** Provides an implicit conversion of any value of type A to MonoidOp[A].
   *
   * @param a the value.
   * @tparam A the type for which we are creating the MonoidOp.
   * @return a MonoidOp[A] that can use |+| operator among other values of type A.
   */
  implicit def toMonoidOp[A : Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
    val F = implicitly[Monoid[A]]
    val value = a
  }
}
