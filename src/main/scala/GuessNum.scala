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
        println(s"$userGuess that's too much! Try again ")
    else {
      println(s"$userGuess that's too little! Try again ")
    }
    userGuess = readInt()
  }


  //TODO get some exit code perhaps
}
