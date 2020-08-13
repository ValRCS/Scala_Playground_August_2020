import scala.io.StdIn.readLine

object AskQuestion extends App {
  val b = 15
  println("Enter your number please :)")
  val c = readLine().toInt //remember we are not sure users will always enter correct answers
  val answer =
    if (b > c) {
      "B is larger than Your Answer"
    } else if (c > b) {
      "Your Answer is larger B"
    } else {
      "B is equal to Your Answer"
    }
  println(answer)
}
