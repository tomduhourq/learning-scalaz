package tomduhourq.learningscalaz.op

import org.scalatest.FlatSpec
import tomduhourq.learningscalaz.monoid.Monoid
import tomduhourq.learningscalaz.monoid.Monoid._
import tomduhourq.learningscalaz.op.MonoidOp._
import tomduhourq.learningscalaz.op.OptionOp._

class OpSpec extends FlatSpec {

  implicit val myListMonoid = listMonoid[Int]

  "MonoidOp" should "operate correctly different types provided with their corresponding monoids" in {
    assert((3 |+| 4) == 7)
    assert(("3" |+| "4") == "34")

    // Nil cannot be the first element of the operation because the compiler cannot infer a Monoid out of Nil without
    // specifying its List type.
    assert((List(1, 2, 3) |+| List(2) |+| Nil |+| List(4, 5)) == List(1, 2, 3, 2, 4, 5))
  }

  "OptionOp" should "pimp Option" in {

    assert(none[Int] == None)
    assert(none[String] == None)
    assert(none[List[Int]] == None)

    assert(1.some == Some(1))
    assert("Tom".some == Some("Tom"))


    assert((none[Int] | 1) == 1)

      //TODO: this is currently not working.
//    assert(~21.some == 21)
  }

}
