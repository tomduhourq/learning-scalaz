package tomduhourq.learningscalaz.polymorphism

object Subtyped {

  trait Plus[A]{
    def plus(a2: A): A
  }

  case class Num(n: Int) extends Plus[Int]{
    def plus(n2: Int) = n + n2
  }

  def plus[A <: Plus[A]](a1: A, a2: A) = a1 plus a2
}
