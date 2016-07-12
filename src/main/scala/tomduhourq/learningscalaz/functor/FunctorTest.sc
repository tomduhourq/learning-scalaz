import scala.concurrent.{Await, ExecutionContext, Future}
import scalaz.Functor
import scalaz.std.list._
import scalaz.std.option._
import scala.concurrent.ExecutionContext.Implicits.global

implicit def FutureFunctor(implicit ec: ExecutionContext) = new Functor[Future] {
  override def map[A, B](fa: Future[A])(f: (A) => B): Future[B] = fa map f
}

val f = Functor[List] compose Functor[Option]

f.map(List(Some(4), None, Some(400))) { _ + 23}

val g = Functor[Future] compose Functor[Option]

val fut = g.map(Future{ Thread.sleep(500); Some(123) }) {_ * 2}

import scala.concurrent.duration._
Await.result(fut, 550 millis)