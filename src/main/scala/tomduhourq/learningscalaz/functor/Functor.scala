package tomduhourq.learningscalaz.functor

import scalaz.syntax.Ops

/**
  * Created by tomas on 21/03/16.
  */
trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

trait FunctorOps[F[_],A] extends Ops[F[A]] {
  implicit def F: Functor[F]

  final def map[B](f: A => B): F[B] = F.map(self)(f)
}
