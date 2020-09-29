package com.github.valrcs

import java.time.LocalTime

object TimeTester extends App {
  import java.time.LocalDate
  val today = LocalDate.now
  println(today)
  println(today.isLeapYear)
  val myTime = LocalTime.now
  println(myTime)
  println(myTime.getMinute)
}
