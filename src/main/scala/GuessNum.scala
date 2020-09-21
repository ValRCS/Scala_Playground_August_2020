import scala.io.StdIn.{readInt, readLine}
import scala.util.Random
//import scala.util.control.Breaks.break

object GuessNum extends App {
  println("Guess the number game")
  val nmin = 1
  val nmax = 100
  val maxTries = 10
  val trueNum = Random.between(nmin, nmax)
  val userName = readLine("What is your name?")
  println(s"What is your guess $userName? Enter number between $nmin and $nmax")
  var userGuess = readInt()
  var gCount = 1
  while (userGuess != trueNum && gCount <= maxTries) {
    if (userGuess > trueNum)
        println(s"Guess No. $gCount: $userGuess TOO BIG! Try again ")
    else {
        println(s"Guess No. $gCount: $userGuess SMALL! Try again ")
    }
    gCount += 1
    userGuess = readInt()
  }
  if (userGuess == trueNum )
    println(s"Nice you won in $gCount tries! the number indeed is $trueNum")
  else
    println(s"Sorry you lost in $gCount tries, your guess was $userGuess while my number is $trueNum")
  //TODO get some exit code perhaps
}
