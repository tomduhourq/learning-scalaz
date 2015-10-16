package tomduhourq.learningscalaz.op

/** This is a creation of mine imitating the pattern followed on the tutorial
  * to be able to have a micro DSL for Options.
  *
  */
//trait OptionOp[A] {
//  val value: Option[A]
//  def some = Some(value)
//  def |(other: => A): A = value match {
//    case Some(s) => s
//    case None    => other
//  }
//}
//
//object OptionOp {
//
//  // The implicit conversion.
//  implicit def toOptionOp[A](a: A) = new OptionOp[A] {
//    val value = a
//  }
//}
