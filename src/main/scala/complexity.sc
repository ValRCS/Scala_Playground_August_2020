import scala.collection.mutable
import scala.collection.mutable.ListBuffer

val max = 100
var sum = BigInt(0)
//two loops that means quadratic complexity
for (i <- 1 to max)
  for (j <- 1 to max)
    sum += (i+j)
println(sum)

val myList = List.range(1, 15)
val myArr = Array.range(1,15)
val mySeq = Seq.range(1,15)
//println(myList)
myList.foreach(println)
myArr.foreach(println)
mySeq.foreach(println)

val myOdd = Seq.range(1,11+1,2)
myOdd.foreach(println)

def myFilter(myNum:Int) = myNum % 3 == 0

//filter is one of the core functional programming concepts
val myFilteredNumbers = mySeq.filter(n => n%2 == 1)
myFilteredNumbers.foreach(println)
//you can use already defined function
val myNumber3 = mySeq.filter(myFilter)
myNumber3.foreach(println)

//FIXME this is the old way of working not recommended
var myMutList = new ListBuffer[Int]()
for (number <- mySeq) {
  println(number)
  if (number % 2 == 1) myMutList+= number
}
val finalList = myMutList.toList
finalList.foreach(println)

val myData = Seq.range(10,50,3)
myData.foreach(println)

//TODO filter from myData only those numbers which divide by 5
//val my5 =