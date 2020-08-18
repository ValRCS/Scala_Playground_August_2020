import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

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
val my5 = myData.filter(n => n % 5 == 0)
my5.foreach(println)

val my500 = my5.map(n => n * 100).filter(n => n > 2000)
my500.foreach(println)

val myGreetings = my500.map(n => s"Hello Mr./Mrs. $n")
myGreetings.foreach(println)
myGreetings.getClass

//TODO print all cubes of even numbers from 10 to 25
//you can use filter or range
//please use map after that
val myNumbers = Seq.range(10,25).filter(n => n %2 == 0)
val myCubes = myNumbers.map(n => n*n*n)
//Seq.range(10,25).filter(n => n %2 == 0).map(n => n*n*n).foreach(println)
myCubes.foreach(println)
myCubes.foreach(item => println(s"My number is $item"))
//(line,i) <- f.getLines().zipWithIndex
for (((item, i), original) <- myCubes.zipWithIndex.zip(myNumbers))
  println(s"No. ${i+1}: original Number ${original} cubed => $item")

//we create an iterable collection of tuples here
val myCollection = myCubes.zip(myNumbers)
myCollection.foreach(println)
myCollection(0).getClass
myCollection(1)._2
for (myTuple <- myCollection) {
  println(myTuple._1,myTuple._2)
  val (myNum, myCube) = myTuple //tuple unpacking
  println(s"So $myNum cubes is $myCube")
}
//this myTuple is new not related to the one above
myCollection.foreach(myTuple => println(myTuple._1,myTuple._2))

//tuples are used for holding anythings, could be different types
//lists, sequences, arrays hold same data types
val myBigTuple = ("Valdis", 45, "Scala", 3, 3.14)
myBigTuple
myBigTuple.getClass

//so we typically go through a collection
//with filters and map new values
//we can use multiple filters and we can map to new values multiple times


val mySquares = Seq.range(1,10).map(n => n*n).map(n => s"my square $n")
mySquares.foreach(println)

Math.random()
Math.random()
// _ refers to variable which we are not using
val myRandoms = Seq.range(1,101).filter(_ => Math.random() < 0.20)
myRandoms.length
//
Random.between(20, 30) //between and 20 and 29
//
val randomSixth = Seq.range(1,101).filter(_ => Random.between(1,7) == 6) // on avery 1/6 of items
val everySixth = Seq.range(1,101).filter(n => n % 6  == 2) //every sixth

randomSixth.length
everySixth.length
