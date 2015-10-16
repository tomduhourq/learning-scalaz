package tomduhourq.learningscalaz.monoidop

import org.scalatest.FlatSpec
import tomduhourq.learningscalaz.monoid.Monoid._
import tomduhourq.learningscalaz.monoidop.MonoidOp._

class MonoidOpSpec extends FlatSpec {

  "MonoidOp" should "operate correctly different types provided with their corresponding monoids" in {
    assert((3 |+| 4) == 7)
    assert(("3" |+| "4") == "34")

    implicit val myListMonoid = listMonoid[Int]

    // Nil cannot be the first element of the operation because the compiler cannot infer a Monoid out of Nil without
    // specifying its List type.
    assert((List(1, 2, 3) |+| List(2) |+| Nil |+| List(4, 5)) == List(1, 2, 3, 2, 4, 5))
  }

}
