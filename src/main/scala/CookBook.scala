import java.io.FileWriter

object CookBook extends App {
//  val srcName = "13177-8.txt"
//  val dstName = "13177-8-results.txt"
  val srcName = "c:/poems/frost.txt"
  val dstName = "c:/poems/frost_cut.txt"
  def openSource(fName:String) = {
    //actually get a real sequence of strings
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines.toSeq

    filePointer.close()
    myLines
  }

  def processSeq(mySeq:Seq[String])= {
    //TODO actually do the assignment
    mySeq.slice(0,8) //just some lines
    //iterative solution
    var newSeq: Seq[String] = Seq()
    for (i <- 0 to 8 by 2) {
      newSeq = newSeq :+ mySeq(i) //so we keep making new sequence using old one as base
    }
    newSeq
    //functional solution
    val funSeq = mySeq.zipWithIndex.filter(t => t._2 % 2 == 0 && t._2 < 12).map(t => t._1) //all even lines under 8
    funSeq
  }

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    mySeq.foreach(println) //we are good up to here
    val fw = new FileWriter(destName)
    mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
    fw.close()
  }

  //the actual program runs here, little tiny pipeline like a factory
  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(mySeq)
  saveSeq(dstName,filteredSeq)
}
