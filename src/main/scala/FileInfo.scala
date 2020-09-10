import java.io.File

object FileInfo extends App {
  println(System.getProperty("user.dir"))

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
  val f_list = getListOfFiles("./")
  f_list.foreach(println)
  getListOfFiles("./src").foreach(println)
  getListOfFiles("./src/resources").foreach(println)
  def getLineCount(fileName:String): Int = {
    var count = 0
    val bufferedSource = io.Source.fromFile(fileName)
    for (line <- bufferedSource.getLines) {
      count += 1
    }
    bufferedSource.close
    count
  }
  def getRowSplitSize(fileName:String): Int = {
    var count = 0
    val bufferedSource = io.Source.fromFile(fileName)
    for (line <- bufferedSource.getLines) {
      val splitLine = line.split(";")
      count += splitLine.size
    }
    bufferedSource.close
    count
  }

  def getLinesWithSplitSize(fileName:String, splitSize:Int): Int = {
    var count = 0
    val bufferedSource = io.Source.fromFile(fileName)
    for (line <- bufferedSource.getLines) {
      val splitLine = line.split(";")
      if (splitLine.size == splitSize){
        println(line)
        count += 1
      }
    }
    bufferedSource.close
    count //return how many lines are there
  }

  def getLineSplits(fileName:String): Seq[Int] = {
    var myListBuf = scala.collection.mutable.ListBuffer[Int]()
    val bufferedSource = io.Source.fromFile(fileName)
    for (line <- bufferedSource.getLines) {
      val splitLine = line.split(";")
      myListBuf += splitLine.size
    }
    bufferedSource.close
    myListBuf.toSeq //return how many lines are there
  }

  def getParsedLines(fileName:String) = {
    var myListBuf = scala.collection.mutable.ListBuffer[Seq[String]]()
    val bufferedSource = io.Source.fromFile(fileName)
    for (line <- bufferedSource.getLines) {
      val splitLine = line.split(";")
      myListBuf += splitLine
    }
    bufferedSource.close
    myListBuf.toSeq //return how many lines are there
  }

  val filePath = "./src/resources/fails_par_2019_gadu.csv"
  val lineCount = getLineCount(filePath)
  println(s"We got a file with $lineCount lines")
  val rowSplitCount = getRowSplitSize(filePath)
  println(s"We got a file with $rowSplitCount lines")
  val linesWith6 = getLinesWithSplitSize(filePath, 6)
  println(linesWith6)
  val myLineSplits = getLineSplits(filePath)
  println(myLineSplits.max, myLineSplits.min)
  val uniques = myLineSplits.toSet //with sets we can check for uniques
  println(uniques)

  val rawSplit = getParsedLines(filePath)
  println(rawSplit.size)
  //TODO filter only the lines with length 8
//  val filteredResults =

}
