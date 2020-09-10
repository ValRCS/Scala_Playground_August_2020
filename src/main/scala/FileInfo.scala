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
      //FIXME find the lines with the splitSize
    }
    bufferedSource.close
    count //return how many lines are there
  }

  val filePath = "./src/resources/fails_par_2019_gadu.csv"
  val lineCount = getLineCount(filePath)
  println(s"We got a file with $lineCount lines")
  val rowSplitCount = getRowSplitSize(filePath)
  println(s"We got a file with $rowSplitCount lines")
  val linesWith7 = getLinesWithSplitSize(filePath, 7)
  println(linesWith7)

}
