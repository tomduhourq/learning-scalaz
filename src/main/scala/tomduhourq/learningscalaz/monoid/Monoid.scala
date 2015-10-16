package tomduhourq.learningscalaz.monoid

/** The idea of monoids is to extract an operation with
  * its corresponding neuter element.
  *
  * @tparam A the type to which the Monoid will be applied on.
  */
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
    def mappend(s1: String, s2: String) = s1 + s2
    def mzero = ""
  }

  /** List Monoid Generator
   *
   * @tparam A the type of the elements inside the Lists we are going to operate on
   * @return a List Monoid of the type A provided
   */
  def listMonoid[A] = new Monoid[List[A]] {
    def mappend(a1: List[A], a2: List[A]): List[A] = a1 ++ a2
    def mzero = Nil
  }

  // This is the most common use of monoids.
  def sum[A : Monoid](as: List[A]) = {
    val monoid = implicitly[Monoid[A]]
    as.foldLeft(monoid.mzero)(monoid.mappend)
  }

  // Now we can abstract also the idea of plus
  def plus[A : Monoid](a1: A, a2: A) = implicitly[Monoid[A]].mappend(a1, a2)
}
