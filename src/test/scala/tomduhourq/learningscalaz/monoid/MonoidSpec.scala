package tomduhourq.learningscalaz.monoid

import org.scalatest.WordSpec
import tomduhourq.learningscalaz.monoid.{Monoid => M}

/**
 * Created by tomas on 16/10/15.
 */
class MonoidSpec extends WordSpec  {

  val alternativeMonoid = new Monoid[Int] {
    def mappend(n1: Int, n2: Int) = n1 * n2
    def mzero = 1
  }

  "Monoids" when {
    "selecting different instances" should {
      "produce a correct result from sum" in {
        assert(M.sum(List(2, 4, 6)) == 12)
        assert(M.sum(List("t", "o", "m")) == "tom")
        assert(M.sum(List(5, 2, 1))(alternativeMonoid) == 10)
        assert(M.sum(List[Int]()) == 0)
        assert(M.sum(List[Int]())(alternativeMonoid) == 1)
      }
    }
  }
}
