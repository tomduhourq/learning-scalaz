package tomduhourq.learningscalaz.truthy

import org.scalatest.FunSuite
import tomduhourq.learningscalaz.op.ToCanIsTruthyOps._

/**
 * References CanTruthy[A]
 */
class CanTruthySpec extends FunSuite {

  implicit val StringTruthy = new CanTruthy[String] {
    override def truthys(a: String): Boolean = a != ""
  }

  implicit val IntTruthy: CanTruthy[Int] = CanTruthy.truthys {
    case 0 => false
    case _ => true
  }

  test("CanTruthy should inject `truthy` method if we got implicit CanTruthy[A]") {
    assert("Sarlompa".truthy, "Non empty String")
    assert(!"".truthy, "Empty String")
  }

  test("CanTruthy also works with CanTruthy.truthys") {
    assert(123.truthy, "Non-zero integer")
    assert(!0.truthy, "Zero!")
  }

  test("truthyIf should work as an if soliciting an implicit CanTruthy in the condition"){
    assert(truthyIf("Should Work"){ "YEAH!" } { "NO!" } == "YEAH!", "If case")
    assert(truthyIf(Nil){ "YEAH!" }{ "NO!" } == "NO!", "Else case")
  }
}
