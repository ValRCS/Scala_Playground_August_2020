import java.io.{File, FileWriter}

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
//  sortedByPrice.slice(0,5).foreach(println)

  println("Expensive Million Plus purchases")
  val millionPurchases = sortedByPrice.filter(_.price >= 1000000)
  millionPurchases.foreach(println)
//  val sortedByValue = ourPurchases.sortWith((p, tp) => p.price / tp.tax_price > p.price / tp.tax_price)
  val bestDeals = ourPurchases.sortBy(el => el.price/el.tax_price).reverse
//  val bestValue = sortedByValue(0)
  println("Best deals")
  bestDeals.reverse.slice(0,15).foreach(println)

  println("Biggest purchases")
  //TODO fix our properties areas
  val fixedArea = ourPurchases.map(
      t => if (t.area > 1) t
      else {
        Purchase(t.region, t.re_num, t.re_type, t.price, t.tax_price, t.area * 10000, t.dom_sk, t.dom_sauc)
      }
  )
  //just an example of selective mapping
  val onlyPrices = ourPurchases.map(t => if (t.price > 2000000) t.price*10 else t.price)
  println(onlyPrices.sorted.reverse.slice(0,5))

  val biggestProperties = fixedArea.sortBy(_.area).reverse
  biggestProperties.slice(0,10).foreach(t => println(s"Area ${t.area}"))
  biggestProperties.reverse.slice(0,10).foreach(t => println(s"Area ${t.area}"))

  println(biggestProperties(0))
  biggestProperties(0).area += 100000
  println(biggestProperties(0))

  def getPrettyText(p: Purchase) :String = {
    s"Area: ${p.area} - Region: ${p.region} - Price: ${p.price} "
  }
  biggestProperties.foreach(prop => println(getPrettyText(prop)))

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    //    mySeq.foreach(println) //we are good up to here
    val fw = new FileWriter(destName)
    mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
    fw.close()
  }
//  val propertyLines = biggestProperties.map(getPrettyText(_))
  val propertyLines = biggestProperties.map(property => getPrettyText(property))

  saveSeq("C:/temp/bigProperties.txt", propertyLines)
}
