trait Summarize {
  val myNum = 5000
  var myChange = 1000
  def sumItAll(numbers:Seq[Int]) = numbers.sum
  def printItAll(numbers:Seq[Any]) = numbers.foreach(println)
}
