//so first trait is extends the rest you do with with
object PlainApp extends Summarize with Stats with CalculatorContract {
  //without extends App
  def main(args: Array[String]) = {
    println("Hello World!")
    for (arg <- args)
      println(s"We got argument: $arg")
    printItAll(args)
    printItAll(Seq(1,3,6,6))
    println(myAvg(Seq(1,6,6,7,8)))
    println(analyzeNumbers(Seq(1,3,6,6)))
    println(myNum)
    myChange += 500
    println(myChange)

  }

  override def analyzeNumbers(numbers: Seq[Int]): String = {
    println(s"Cool we got something ${numbers.sum}")
    s"Cool we got something ${numbers.sum}"
  }

  override def reduceNumbers(numbers: Seq[Int]): Int = 9000
}
