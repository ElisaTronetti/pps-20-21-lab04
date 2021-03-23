package u04lab.code

import Lists._
import u04lab.code.Lists.List._

trait Student {
  def name: String
  def year: Int
  def enrolling(courses: Course*): Unit // the student participates to a Course
  def courses: List[String] // names of course the student participates to
  def hasTeacher(teacher: String): Boolean // is the student participating to a course of this teacher?
}

trait Course {
  def name: String
  def teacher: String
}

object Student {
  def apply(name: String, year: Int = 2017): Student = new StudentImpl(name, year)

  private class StudentImpl(override val name: String, override val year: Int) extends Student{

    private var listOfCourses: List[Course] = Nil()

    override def enrolling(courses: Course*): Unit = {
      for (c <- courses){
        listOfCourses = append(listOfCourses, Cons(c, Nil()))
      }
    }

    override def courses: List[String] = map(listOfCourses)(_.name)

    override def hasTeacher(teacher: String): Boolean = contains(listOfCourses)(_.teacher == teacher)
  }
}

object Course {
  def apply(name: String, teacher: String): Course = CourseImpl(name, teacher)

  //implementing Course as a case class
  private case class CourseImpl(override val name: String, override val teacher: String) extends Course
}
