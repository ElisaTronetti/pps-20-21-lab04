package u04lab.code

import org.junit.jupiter.api.Test
import Lists.List
import org.junit.jupiter.api.Assertions.assertEquals

class ListTest {

  @Test def testListFactory(){
    val list = List(1,2,3,4) //the factory created allows to create a list with more than one element
    assertEquals(List.Cons(1, List.Cons(2, List.Cons(3, List.Cons(4, List.Nil())))), list)
  }
}
