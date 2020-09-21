import scala.io.StdIn.readLine
import scala.util.Random

object BlackJack extends App {
  println("Let's play black Jack!")
  //TODO we need card deck Seq of Tuples or possibly Sequence of Card class
  val computerStops = 17
  val suits = Seq("diamonds","hearts","clubs","spades")
  val cardVals = Range(2,11).map(_.toString)
  val allVals = cardVals ++ Seq("J","Q","K","A")
//  println(allVals)
  val cardValues = Range(2,11).toSeq ++ Seq(10,10,10,1) //FIXME Ace 1 or 11
  val cardTup = allVals zip cardValues
//  println(cardTup)
  val cross = cardTup.flatMap(x => suits.map(y => (x,y)))
//  println(cross)
  val cardDeck = cross.map(card => ((card._1._1, card._2), card._1._2))
//  println(cardDeck)
  var gameDeck = Random.shuffle(cardDeck)
//  println(gameDeck)
  var playerDeck = Seq(gameDeck.last)
  gameDeck = gameDeck.init // everyting but last element
  playerDeck.foreach(println)
  var command = readLine("(S)top or (H)it ?")
  var score = playerDeck.map(_._2).sum
  while (!command.startsWith("S") && score < 21) {
    playerDeck = playerDeck ++ Seq(gameDeck.last)
    gameDeck = gameDeck.init // everything but last element
    playerDeck.foreach(println)
    score = playerDeck.map(_._2).sum //FIXME score function!!
    println(s"Your score is $score")
    command = readLine("(S)top or (H)it ?")
  }

  if (score == 21) {
    println("Nice blackjack! You WIN!!!")
  } else if (score > 21) {
    println(s"You lose! with $score")
  } else {
    println("Let's see what the computer does...")
    var computerScore = 0
    var computerDeck = Seq(gameDeck.last)
    while (computerScore < 21 && computerScore < computerStops) {
      computerDeck = computerDeck ++ Seq(gameDeck.last)
      gameDeck = gameDeck.init // everything but last element
      computerDeck.foreach(println)
      computerScore = computerDeck.map(_._2).sum //FIXME score function def a score function
      println(s"Computer score is $computerScore")
    }
    if (computerScore > score) {
      println("Computer wins!")
    } else {
      println("You win!")
    }
    println("Computer deck:")
    computerDeck.foreach(println)
    println("*"*40)
    println("Your cards")
    playerDeck.foreach(println)
  }




  //UserDeck
  //Then ComputerDeck
  //And User loses if over 21
  //Tie if both even
  //Computer losers if over 21
  //UserName
  //TODO separate functionality into modules
}
