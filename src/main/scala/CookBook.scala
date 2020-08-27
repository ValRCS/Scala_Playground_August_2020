object CookBook extends App {
  val srcName = "13177-8.txt"
  val dstName = "13177-8-results.txt"
  def openSource(fName:String) = {
    //actually get a real sequence of strings
    Seq("abra","dabra") //just a placeholder
  }

  def processSeq(mySeq:Seq[String])= {
    Seq("RECIPE","ingredient") //another placeholder
  }

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    scala.util.Success
  }

  //the actual program runs here, little tiny pipeline like a factory
  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(Array("Val","Some"))
  saveSeq(dstName,filteredSeq)
}
