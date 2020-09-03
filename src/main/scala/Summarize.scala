trait Summarize {
  def sumItAll(numbers:Seq[Int]) = numbers.sum
  def printItAll(numbers:Seq[Any]) = numbers.foreach(println)
}
