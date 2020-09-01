val mySeq = for (i <- 1 to 8 by 2) yield i
//for clause yield body
val myStrSeq = for (i <- 1 to 8 by 2) yield s"My string $i"

val food = "potatoes"
val big_food = for (c <- food) yield c.toUpper
val big_food_too = food.map(_.toUpper)
var bigText = ""
//with curly braces i can do more stuff inside the for loop to createnew sequence
val crazy_seq = for {
  c <- food
  bigLetter = c.toUpper
  someText = s"TEXT: $bigLetter"
}  yield someText



