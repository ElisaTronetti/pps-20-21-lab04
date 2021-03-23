package u04lab.code

import Optionals._
import Lists._
import Lists.List._
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PowerIteratorsTest {

  val factory = new PowerIteratorsFactoryImpl()

  @Test def testIncremental(){
    val pi = factory.incremental(5,_+2) // pi produce 5,7,9,11,13,...
    assertEquals(Option.of(5), pi.next())
    assertEquals(Option.of(7), pi.next())
    assertEquals(Option.of(9), pi.next())
    assertEquals(Option.of(11), pi.next())
    assertEquals(List.Cons(5, List.Cons(7, List.Cons(9, List.Cons(11,List.Nil())))), pi.allSoFar()) // elementi già prodotti
    for (i <- 0 until 10) {
      pi.next() // procedo in avanti per un po'..
    }
    assertEquals(Option.of(33), pi.next()) // sono arrivato a 33
  }

  @Test def testIncrementalReverse(){
    var pi = factory.incremental(5, _ + 2) // pi produce 5,7,9,11,13,...
    assertEquals(Option.of(5), pi.next())
    assertEquals(Option.of(7), pi.next())
    assertEquals(List.Cons(5, List.Cons(7,List.Nil())), pi.allSoFar())

    pi = pi.reversed() //the new initial point of the new power iterator is 7
    assertEquals(Option.of(7), pi.next())
    assertEquals(Option.of(5), pi.next())
    assertEquals(Option.empty, pi.next())
    assertEquals(List.Cons(7, List.Cons(5,List.Nil())), pi.allSoFar())
  }

  @Test def testFromList(){
    val lst = List.Cons(3,List.Cons(7,List.Cons(1,List.Cons(5, List.Nil()))))
    val pi = factory.fromList(lst)
    assertEquals(Option.of(3), pi.next())
    assertEquals(Option.of(7), pi.next())
    assertEquals(List.Cons(3, List.Cons(7, Nil())), pi.allSoFar())

    for (i <- 0 until 10) {
      pi.next() // procedo in avanti per un po'..
    }
    assertEquals(Option.empty, pi.next())
  }

  @Test def testFromListReverse(){
    val lst = List.Cons(3,List.Cons(7,List.Cons(1,List.Cons(5, List.Nil()))))
    var pi = factory.fromList(lst)
    assertEquals(Option.of(3), pi.next())
    assertEquals(Option.of(7), pi.next())
    assertEquals(List.Cons(3, List.Cons(7, Nil())), pi.allSoFar())

    pi = pi.reversed()
    assertEquals(Option.of(7), pi.next())
    assertEquals(Option.of(3), pi.next())
    assertEquals(Option.empty, pi.next())
    assertEquals(List.Cons(7, List.Cons(3,List.Nil())), pi.allSoFar())
  }

  //I don't actually know how to test this
  @Test def testRandomBooleans(){
    val pi = factory.randomBooleans(3)
    pi.next()
    pi.next()
    pi.next()
    println("Boolean random: " + pi.allSoFar())
    assertEquals(Option.empty, pi.next())
  }
}