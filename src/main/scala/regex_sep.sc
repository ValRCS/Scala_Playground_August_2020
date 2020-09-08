val myStrings = Seq("Valdis","0324325","Maija", "3432423HMMM", "9332432ffda")
val myNums = myStrings.filter(t => t matches "(^[0-9]+.*)")
val notNums = myStrings.filterNot(t => t matches "(^[0-9]+.*)")
  //lets see if we can avoid regex here
val digits = Range(0,10)
val digitStr = Range(0,10).map(_.toString)
digitStr.exists(n => myStrings(1).startsWith(n))
digits.exists(n => myStrings(1).startsWith(n.toString))
val myNums2 = myStrings.filter(t => digits.exists(n => t.startsWith(n.toString)))
// we can avoid regex but it is not as simple as we thought :)
println(digits)
digits.exists(n => n*n == 25)
digits.exists(n => n*n == 22)
digits.exists(n => n*n == 16)

//val squares = Range(1,101).filter(num => )

val text = "CAPITAL small BIG 9999"
val arr = text.toArray
val capitals = arr.filter(_.isUpper)

//val capAgain = arr.filter(c => c.toString matches "[A-Z]")
val capText2 = text.filter(_.isUpper)
val capText = text.filter(c => c.toString matches "[A-Z]")

// forall is Universal all items in sequence have this https://en.wikipedia.org/wiki/Universal_quantification
val isAllCaps = "ABBA".forall(_.isUpper)
"ABBAddd".forall(_.isUpper)

Range(0,10).forall(_ > -3)
Range(0,10).forall(_ > 2) //we need all to be true
Range(0,10).exists(_ > 2) //we just need one to be true
Range(0,10).exists(_ > 12)

def myExists(mySeq:Seq[Int], myNeedle:Int) = {
  var result = false
  for (n <- mySeq) {
    if (myNeedle == n) result = true
  }
  result
}

myExists(Range(0,10), 4)
myExists(Range(0,10), 14)
Range(0,10).exists(_ == 4)

