package u04lab.code

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class ComplexTest {

  @Test def testComplexClassEquals(){
    val a = new ComplexImpl(1,1)
    val b = new ComplexImpl(1,1)
    println("Print class complex: " + a) //not working
    assertNotEquals(a, b)
    assertFalse(a == b)
    assertFalse(a.equals(b))
    assertFalse(a.eq(b)) //checking reference equality
    assertTrue(a.eq(a))
  }

  @Test def testComplexClassSum(){
    val a = Array(new ComplexImpl(10,20), new ComplexImpl(1,1), new ComplexImpl(7,0))
    val c = a(0) + a(1) + a(2)
    assertNotEquals(new ComplexImpl(18,21), c)
    assertEquals(18, c.re)
    assertEquals(21, c.im)
  }

  @Test def testComplexClassProduct(){
    val a = Array(new ComplexImpl(10,20), new ComplexImpl(1,1), new ComplexImpl(7,0))
    val c = a(0) * a(1)
    assertNotEquals(new ComplexImpl(-10,30), c)
    assertEquals(-10, c.re)
    assertEquals(30, c.im)
  }

  @Test def testComplexCaseClassEquals(){
    val a = Complex(1,1)
    val b = Complex(1,1)
    println("Print case class complex: " + a) //working
    assertEquals(a, b)
    assertTrue(a == b)
    assertTrue(a.equals(b))
    assertFalse(a.eq(b)) //checking reference equality
    assertTrue(a.eq(a))
  }

  @Test def testComplexCaseClassSum(){
    val a = Array(Complex(10,20), Complex(1,1), Complex(7,0))
    val c = a(0) + a(1) + a(2)
    assertEquals(Complex(18,21), c)
    assertEquals(18, c.re)
    assertEquals(21, c.im)
  }

  @Test def testComplexCaseClassProduct(){
    val a = Array(Complex(10,20), Complex(1,1), Complex(7,0))
    val c = a(0) * a(1)
    assertEquals(Complex(-10,30), c)
    assertEquals(-10, c.re)
    assertEquals(30, c.im)
  }

}
