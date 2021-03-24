package u04lab.code

import org.junit.jupiter.api.Test
import Lists._
import org.junit.jupiter.api.Assertions.assertEquals

class SameTeacherTest {

  @Test def testSameTeacher() {
    val cPPS = Course("PPS","Viroli")
    val cOOP = Course("OOP","Viroli")
    val courses = List(cPPS, cOOP)

    courses match {
      case SameTeacher(t) =>
        println(s"$courses have same teacher $t")
        assertEquals("Viroli", t)
      case _ => println ( s" $courses have different teachers ")
    }
  }

  @Test def testDifferentTeachers(): Unit ={
    val cPPS = Course("PPS","Viroli")
    val cOOP = Course("OOP","Viroli")
    val cPCD = Course("PCD","Ricci")
    val cSDR = Course("SDR","D'Angelo")
    val courses = List(cPPS, cOOP, cPCD, cSDR)

    courses match {
      case SameTeacher(t) => println(s"$courses have same teacher $t")
      case _ => println ( s" $courses have different teachers ")
    }
  }
}
