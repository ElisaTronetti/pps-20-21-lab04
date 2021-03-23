package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List._

class StudentTest {

  @Test def testCourseCreation(){
    val cPPS = Course("PPS", "Viroli")
    assertEquals("PPS", cPPS.name)
    assertEquals("Viroli", cPPS.teacher)
    println("Course: " + cPPS) //just to show that with the case class the toString is automatically implemented
  }

  @Test def testStudentCreation(){
    val s = Student("Elisa", 2020)
    assertEquals("Elisa", s.name)
    assertEquals(2020, s.year)
    println("Student: " + s) //I didn't implemented the toString in Student, the println is not useful
  }

  @Test def testStudentDefaultYear(){
    val s = Student("Alessandro") //defaults to 2017
    assertEquals("Alessandro", s.name)
    assertEquals(2017, s.year)
  }

  @Test def testCourseEnrolling(){
    val cPPS = Course("PPS","Viroli")
    val cPCD = Course("PCD","Ricci")
    val cSDR = Course("SDR","D'Angelo")

    val s1 = Student("Elisa", 2020)
    val s2 = Student("Alessandro")

    s1.enrolling(cPPS, cPCD)
    s2.enrolling(cSDR)

    assertEquals(Cons("PPS", Cons("PCD", Nil())), s1.courses)
    assertEquals(Cons("SDR", Nil()), s2.courses)
  }

  @Test def testHasTeacher(){
    val cPPS = Course("PPS","Viroli")
    val cPCD = Course("PCD","Ricci")
    val s1 = Student("Elisa", 2020)
    s1.enrolling(cPPS, cPCD)

    assertTrue(s1.hasTeacher("Ricci"))
    assertFalse(s1.hasTeacher("Maio"))
  }

}
