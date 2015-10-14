package tomduhourq.learningscalaz.polymorphism

object AdHoc {

  trait Plus[A]{
    def plus(a1: A, a2: A): A
  }

  implicit val intPlus = new Plus[Int] {
    def plus(a1: Int, a2: Int) = a1 + a2
  }

  implicit val strPlus = new Plus[String]{
    def plus(a1: String, a2: String) = a1 + " " + a2
  }

  def plus[A : Plus](a1: A, a2: A) = implicitly[Plus[A]].plus(a1, a2)
}
