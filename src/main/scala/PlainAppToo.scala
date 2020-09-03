
object PlainAppToo extends App with Summarize with ManyTraits with AnotherTrait {
  println(myChange)
  myChange += 300
  println(myChange)
  val dataA = new NumData()
  val dataB = new NumData()
  dataA.myChange += 350
  println(dataA.myChange, dataB.myChange, myChange)
  println(sumItAll(Seq(1,2,66)))
  println(dataA.sumItAll(Seq(6,6,2,70)))
  println(foo())
  println(superfood())
}
