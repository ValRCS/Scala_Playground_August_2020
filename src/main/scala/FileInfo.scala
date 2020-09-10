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
  val lineCount = getLineCount("./src/resources/fails_par_2019_gadu.csv")
  println(s"We got a file with $lineCount lines")
}
