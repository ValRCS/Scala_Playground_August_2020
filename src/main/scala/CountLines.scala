import java.io.File

import scala.io.Source

//will count lines from first files given as argument
object CountLines extends App{
  var longestLine = ""
  var fileName = ""
  var lineNumber = -1
  //read arg
  //read text file
  //loop through each line and count length
  //keep a running total of all characters

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  println("Running CountLines")
  if (args.length == 1) { //at least one file
    //outer loop for looping through multiple file names
    val fList = getListOfFiles(args(0))
    for (arg <- fList) {//for each argument in our arguments do the below loop
      println(s"Working now on file $arg")
      println("*"*40)
      //then we start the inner loop for each file
      val f = scala.io.Source.fromFile(arg)
      for ((line,i) <- f.getLines().zipWithIndex) {
        println(s"${line.length.toString}::: $line")
        //we compare old record with new record and save if the record is beaten lets beat this line record here i hope for sure
        if (line.length > longestLine.length) {
          longestLine = line
          if (fileName != arg.toString) fileName = arg.toString //tiny optimization which is not really necessary
          lineNumber = i
        }
      }
      f.close() //We need to close open files TODO add in try finally
    }

  } else {
    println("You need to enter file as command argument")
  }
  //TODO actually find the line
  println(s"The length of longest line is ${longestLine.length}")
  println(longestLine)
  println(s"This line is number ${lineNumber+1} in file $fileName")
  println(getListOfFiles("."))
}
