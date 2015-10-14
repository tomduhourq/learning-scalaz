package tomduhourq.learningscalaz.monoid

trait Monoid[A] {
  def mappend(a1: A, a2: A): A
  def mzero: A
}

object Monoid {

  implicit val intMonoid = new Monoid[Int] {
    def mappend(n1: Int, n2: Int) = n1 + n2
    def mzero = 0
  }

  implicit val strMonoid = new Monoid[String] {
    def mappend(s1: String, s2: String) = s1 + " " + s2
    def mzero = ""
  }

  def sum[A : Monoid](as: List[A]) = {
    val monoid = implicitly[Monoid[A]]
    as.foldLeft(monoid.mzero)(monoid.mappend)
  }
}
