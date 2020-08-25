import java.io.FileNotFoundException

import scala.io.Source

val fileName = "c:/poems/frost.txt" //TODO make relative path absolute path generally to be avoid

//for (line <- Source.fromFile(fileName).getLines)
//  println(line)
var myText = Seq[String]()
try {
  val filePointer = scala.io.Source.fromFile(fileName)
  val myLines = filePointer.getLines
  myText = myLines.toSeq
  filePointer.close()
} catch {
  //you catch specific errors for your needs
  case ex: FileNotFoundException =>
    println(s"file not found $ex")
}
myText.foreach(println)

//find the longest line of text in the poem
myText(0)
myText.sorted.reverse(0) //this gets alphabetical sort
myText.sortBy(_.size).reverse(0)
println(res3.size, res4.size)


val sortedAscending = myText.filter(_.size > 0).sortBy(_.size)
sortedAscending(0)
myText.filter(_.size > 0).sortBy(_.size).toSeq(0) //workaround

//words are defined by groups of characters separated by space
//so probably split would come in handy
res6.split(" ").size
val mostWords = myText.sortBy(_.split(" ").size).reverse(0)
mostWords

val leastWords = myText.filter(_.size > 0).sortBy(_.split(" ").size).toSeq(0)
leastWords

// Iteration
var longestLine = ""
for(line <- myText)
  if (line.size > longestLine.size)
    longestLine = line

longestLine
//two approaches
//iteration with record
//sorting

//filter only lines starting with And
"And looked down".slice(0,3)
"An".slice(0,3)

//we will return and check on a solution


//myLines.foreach(println) //Iterator is exhausted
//myLines.foreach(println)
//myText.foreach(println)
//myText.foreach(println)



//we should close the file when we are done


//return the longest line from myText
//


//System.setProperty("user.dir", "c:/Users/val-p1/")
//print(System.getProperty("user.dir"))
//System.setProperty("user.dir", "~/Scala_Test")
//print(System.getProperty("user.dir"))
//val newPath = "Scala_Test/resources/poem.txt"
//for (line <- Source.fromFile(newPath).getLines)
//  println(line)
//print(System.getProperty("user.dir"))
//Source.fromResource("poem.txt")
