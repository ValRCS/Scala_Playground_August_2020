import java.io.{FileNotFoundException, FileWriter}

object ReadWriteFile extends App {
  println(s"First Arg is", args(0))
  println(System.getProperty("user.dir"))
  val srcName = if (!args.isEmpty) args(0) else "c:/poems/frost.txt"
  val destName = if (args.length >= 2) args(1) else "c:/poems/results.txt"
  val filterWord = "road"
  var myText = Seq[String]()
  try {
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines
    myText = myLines.toSeq
    filePointer.close()
  } catch {
    //you catch specific errors for your needs
    case ex: FileNotFoundException =>
      println(s"file not found $ex")
      //we would want to return here actually
  }
  val fw = new FileWriter(destName, true)
  fw.write("My Results are:\n")
  myText.filter(_.contains(filterWord)).map(_ + "\n").foreach(fw.write)
  fw.close()
  println(s"All done processing file $srcName into $destName by finding lines with $filterWord")
}
