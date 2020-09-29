package com.github.valrcs

import com.github.valrcs.UniqueDigits.getRandomUniqueDigits

object UniqueDigits extends App {
  def getRandomUniqueDigits(digitSeq: String = "0123456789", getDigitCount: Int = 4) = {
    val digitList = digitSeq.toList
    val shuffledList = scala.util.Random.shuffle(digitList)
    val offset = if (shuffledList(0) != '0') 0 else 1
     val myDigits = shuffledList.slice(offset, getDigitCount+offset)
//    println(myDigits.mkString(""))
    myDigits.mkString("").toInt
  }
//  println(getRandomUniqueDigits(getDigitCount = 5))
//  println("*"*30)
//  println(getRandomUniqueDigits())
//  for (i <- 0 to 10) println(getRandomUniqueDigits())
  val lotsOfNumbers = for (i <- 1 to 10000) yield getRandomUniqueDigits()
  val under1200 = lotsOfNumbers.filter(_ < 1200)
  under1200.foreach(println)
}
