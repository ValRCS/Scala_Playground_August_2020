// so basically a contract an obligate to whoever uses this trait to write their own analyzeNumbers
trait CalculatorContract {
  def analyzeNumbers(numbers:Seq[Int]) : String
  def reduceNumbers(numbers:Seq[Int]) : Int
}
