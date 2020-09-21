import scala.io.StdIn.{readInt, readLine}
import scala.util.Random

object GuessNum extends App {
  println("Guess the number game")
  val nmin = 1
  val nmax = 100
  val trueNum = Random.between(nmin, nmax)
  val userName = readLine("What is your name?")
  println(s"What is your guess $userName? Enter number between $nmin and $nmax")
  var userGuess = readInt()
  while (userGuess != trueNum) {
    if (userGuess > trueNum)
        println(s"$userGuess TOO BIG! Try again ")
    else {
      println(s"$userGuess SMALL! Try again ")
    }
    userGuess = readInt()
  }
  print(s"Nice you won! the number indeed is $trueNum")
  //TODO get some exit code perhaps
}
