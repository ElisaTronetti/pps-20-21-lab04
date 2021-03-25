package u04lab.code

import Optionals._
import Lists._
import u04lab.code.Lists.List.{Cons, Nil, nil}
import Streams._

import scala.util.Random

trait PowerIterator[A] {
  def next(): Option[A]
  def allSoFar(): List[A]
  def reversed(): PowerIterator[A]
}

trait PowerIteratorsFactory {

  def incremental(start: Int, successive: Int => Int): PowerIterator[Int]
  def fromList[A](list: List[A]): PowerIterator[A]
  def randomBooleans(size: Int): PowerIterator[Boolean]
}

class PowerIteratorsFactoryImpl extends PowerIteratorsFactory {

  //companion object, used to hide the actual class implementation
  object PowerIterator {
    def apply[A](stream : Stream[A]): PowerIterator[A] = new PowerIteratorImpl(stream)

    private class PowerIteratorImpl[A](private var stream: Stream[A]) extends PowerIterator[A]{

      private var pastList: List[A] = nil

      override def next(): Option[A] = {
        //simplified implementation
        stream match {
          case Stream.Cons(head, tail) =>
            pastList = List.append(pastList, Cons(head(), Nil()))
            stream = tail()
            Option.of(head())
          case Stream.Empty() => Option.empty
        }
        //old implementation
        /*
        val nextElem = Stream.head(stream)
        stream = Stream.tail(stream)
        nextElem match {
          case Option.Some(x) =>
            pastList = List.append(pastList, Cons(x, Nil()))
            nextElem
          case _ => nextElem
        } */
      }

      override def allSoFar(): List[A] = pastList

      override def reversed(): PowerIterator[A] = new PowerIteratorsFactoryImpl().fromList(List.reverse(pastList))
    }
  }

  override def incremental(start: Int, successive: Int => Int): PowerIterator[Int] = PowerIterator(Stream.iterate(start)(successive))

  override def fromList[A](list: List[A]): PowerIterator[A] = PowerIterator(Stream.fromList(list))

  override def randomBooleans(size: Int): PowerIterator[Boolean] = PowerIterator(Stream.take(Stream.generate(Random.nextBoolean()))(size))
}
