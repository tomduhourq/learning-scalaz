package tomduhourq.learningscalaz

import org.scalatest.{Matchers, FreeSpec}
import tomduhourq.learningscalaz.polymorphism.AdHoc
import tomduhourq.learningscalaz.polymorphism.Parametric._
import tomduhourq.learningscalaz.polymorphism.Subtyped._

class PolymorphismSpec extends FreeSpec with Matchers {

  "Different kinds of polymorphism" - {
    "Parametric" - {
      "should return the first element of different kinds of lists" in {
        val ints = List(1, 2, 3)
        val strings = List("je", "jo", "ju")
        head(ints) should be (1)
        head(strings) should be ("je")
      }

      "should throw an IndexOutOfBoundsException correctly" in {
        intercept[IndexOutOfBoundsException](head(Nil))
      }
    }

    "Subtyped" - {
      "should return the sum of two numbers" in {
        Num(2) plus(4) should be (6)
      }
    }

    "Ad-Hoc" - {
      "should return the sum of two numbers" in {
        AdHoc.plus(1, 3) should be (4)
        AdHoc.plus("je", "je") should be ("je je")
      }
    }
  }
}
