package u04lab.code

import Lists._

object SameTeacher {
  def unapply(courses: List[Course]): Option[String] = {
    List.map(courses)(_.teacher) match {
      case List.Cons(head, tail) => if (List.allMatch(head)(tail)) Some(head) else Option.empty
      case List.Nil() => Option.empty
    }
  }

}
