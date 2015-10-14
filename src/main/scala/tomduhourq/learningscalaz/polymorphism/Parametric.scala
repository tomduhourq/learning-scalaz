package tomduhourq.learningscalaz.polymorphism

object Parametric {
  def head[A](xs: List[A]): A = xs(0)
}
