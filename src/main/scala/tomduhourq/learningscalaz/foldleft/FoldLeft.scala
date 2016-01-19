package tomduhourq.learningscalaz.foldleft

import tomduhourq.learningscalaz.monoid.Monoid
import scala.language.higherKinds

/** Another abstraction to represent the idea of folding.
  * This typeclass will apply the widely known foldLeft operation on a
  * container type
  *
  * @tparam F the container type to apply the operation on.
  */
trait FoldLeft[F[_]] {
  def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
}

object FoldLeft {
  implicit val foldLeftList = new FoldLeft[List] {
    def foldLeft[A, B](xs: List[A], seed: B, f: (B, A) => B) = xs.foldLeft(seed)(f)
  }

  // Same operation as with Monoid, but pulling out the idea of FoldLeft.
  def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
    val m = implicitly[Monoid[A]]
    val fl = implicitly[FoldLeft[M]]
    fl.foldLeft(xs, m.mzero, m.mappend)
  }
}
