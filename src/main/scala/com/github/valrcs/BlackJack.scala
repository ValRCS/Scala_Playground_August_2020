package com.github.valrcs

import scala.io.StdIn.readLine
import scala.util.Random

object BlackJack extends App {
  val computerStops = 17

  /**
   *
   * @return
   */
  def getRandomDeck() = {
    val suits = Seq("diamonds", "hearts", "clubs", "spades")
    val cardVals = Range(2, 11).map(_.toString)
    val allVals = cardVals ++ Seq("J", "Q", "K", "A")
    //  println(allVals)
    val cardValues = Range(2, 11).toSeq ++ Seq(10, 10, 10, 1)
    val cardTup = allVals zip cardValues
    //  println(cardTup)
    //cross product here
    val cross = cardTup.flatMap(x => suits.map(y => (x, y)))
    //  println(cross)
    val cardDeck = cross.map(card => ((card._1._1, card._2), card._1._2))
    val cardClassDeck = cardDeck.map(card => Card(card._1._1, card._1._2, card._2))
    //    Random.shuffle(cardDeck)
    Random.shuffle(cardClassDeck)
  }

  def getScore(deck: Seq[Card]) = {
    var preScore = deck.map(_.cardValue).sum
    val sortedDeck = deck.sortBy(_.cardValue)
    if (sortedDeck.head.rank == "A" && preScore <= 11) {
      preScore += 10 //so only one Ace can improve our position, two Aces would be 22
    }
    preScore
  }

  def main() = {
    println("Let's play black Jack!")
    var gameDeck = getRandomDeck()
    //  println(gameDeck)
    var playerDeck = Seq(gameDeck.last)
    gameDeck = gameDeck.init // everything but last element
    playerDeck.foreach(println)
    var command = readLine("(S)top or (H)it ?")

    var score = getScore(playerDeck)
    while (!command.startsWith("S") && score < 21) {
      playerDeck = playerDeck ++ Seq(gameDeck.last)
      gameDeck = gameDeck.init // everything but last element
      playerDeck.foreach(println)
      score = getScore(playerDeck)
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
      gameDeck = gameDeck.init
      while (computerScore < 21 && computerScore < computerStops) {
        computerDeck = computerDeck ++ Seq(gameDeck.last)
        gameDeck = gameDeck.init // everything but last element
        computerDeck.foreach(println)
        computerScore = getScore(computerDeck)
        println(s"Computer score is $computerScore")
      }
      if (computerScore > 21) {
        println("You win!")
      } else if (computerScore > score) {
        println("Computer wins!")
      } else {
        println("You win!")
      }
      println("Computer deck:")
      computerDeck.foreach(println)
      println("*" * 40)
      println("Your cards")
      playerDeck.foreach(println)
    }
  }

  main()
}
