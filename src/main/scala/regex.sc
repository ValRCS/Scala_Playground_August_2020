val rawStr = "35 hundred potatoes in 2020 and some more ddd dummy data 5!@#$ a8loons"
//start by splitting
val mySeq = rawStr.split(" ")
mySeq(0).toInt
// so for all will return a true or false depending whether all characters are digits
mySeq(0).forall(_.isDigit)
mySeq(0).forall(c => c.isDigit) // same as above line
mySeq(1).forall(_.isDigit)

//get me only Numbers out of the sequence of strings
//val onlyNumbers = mySeq.filter(txt => txt(0).isDigit) //FIXME this would work here but not 100%
val onlyNumbers = mySeq.filter(item => item.forall(c => c.isDigit)) //this would work here but not 100%
mySeq.filter(_.forall(_.isDigit))
mySeq.filter(_.exists(_.isDigit))
//for all is just like making a huge line of ifs for each item

//forall goes through each item and returns boolean if all items match the inside function
//foreach actually does something with each item for example print
"Valdis".forall(_.isUpper)
"Valdis".toUpperCase.forall(_.isUpper)
"VALDIS".forall(_.isUpper)

"Valdis".exists(_.isUpper)
"aaaDadfadfa".exists(_.isUpper)

//to conclude exists will be true if at least one item in collection is true to the function inside
//forall will need all items to be true when called by inner funciton

val regex = "(\\d+)"
mySeq.filter(item => item matches regex)

val rx = "(d\\w+)"
mySeq.filter(item => item matches rx)

//this how you would use it with looping and mutable collection
var resultsSeq = scala.collection.mutable.Seq[String]()
for (item <- mySeq)
  if (item(0) == 'd' ) {
    println(s"Found match $item")
    resultsSeq = resultsSeq :+ item //append to mutable sequence
  }
    //add to resultsSeq

resultsSeq

//get me the same result without regex, all items starting with letter d
//try to get a regex that the same thing :)
