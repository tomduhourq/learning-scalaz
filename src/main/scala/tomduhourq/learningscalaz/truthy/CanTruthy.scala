package tomduhourq.learningscalaz.truthy

/**
 * Boolean typeclass.
 */
trait CanTruthy[A] { self =>
  def truthys(a: A): Boolean
}

object CanTruthy {
  def apply[A](implicit ev: CanTruthy[A]) = ev
  def truthys[A](f: A => Boolean) = new CanTruthy[A] {
    def truthys(a: A) = f(a)
  }

  // Identity
  implicit val booleanCanTruthy: CanTruthy[Boolean] = CanTruthy.truthys(identity)

  // Some CanTruthy examples
  implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys {
    case 0 => false
    case _ => true
  }

  implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truthys {
    case Nil => false
    case _   => true
  }

  // Since A is invariant, you need to define a new CanTruthy[Nil], so you can do Nil.truthy
  implicit val nilCanTruthy: CanTruthy[scala.collection.immutable.Nil.type] = CanTruthy.truthys(_ => false)
}

