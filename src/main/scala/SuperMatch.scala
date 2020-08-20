object SuperMatch extends App {
  def hat(x: Any): String = x match {

    //main takeaway - start more specific and go down to more general
    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty List"

    // sequence patterns
    case List(_, _, 4) => "a three-element list 4 as 3rd element"
    case List(0, _, _) => "a three-element list with 0 as the first element"
    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector starting with 1, having any number of elements"

    // tuples
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b, and $c"

    // typed patterns
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => m.toString

    // the default wildcard pattern
    case _ => "Unknown"
  }
  println(hat(0))
  println(hat("Valdis"))
  println(hat(List(0,1,200)))
  println(hat(Array(1,2,7,155)))
  println(hat(Array("Valdis","Ruta", "Maija")))
  println(Array("Valdis","Ruta", "Maija").mkString(":::"))//in some other languages this is called join
  println(hat(List(1,2,4,6,6)))
  println(hat(List(1,2,4)))
}
