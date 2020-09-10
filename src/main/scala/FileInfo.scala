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

  def getPurchaseSeq(splitLineSeq: Seq[Seq[String]]) : Seq[Purchase] = {
    splitLineSeq.map(t => Purchase(t(0),t(1).toLong,t(2),t(3).toDouble,t(4).toInt,t(5).toDouble,t(6).toInt,t(7).toLong))
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
  println(rawSplit(3))

//  val filteredResults =
  val filteredResults = rawSplit.filter(_.size == 8)
  println(filteredResults.size)
  println(rawSplit(0))
  val ourPurchases = getPurchaseSeq(filteredResults.slice(1,filteredResults.size))
//  println(ourPurchases(0))
  val sortedByPrice = ourPurchases.sortBy(_.price).reverse
  sortedByPrice.slice(0,5).foreach(println)

  //TODO find all million plus purchases
  //TODO find the best deals meaning sort by purchase / tax_price ratio
}
