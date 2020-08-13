import scala.jdk.FunctionWrappers.FromJavaDoubleToIntFunction

def print2() = {
  println("One Line")
  println("Second Line")
}
print2()
print2()

//Unit is basically an empty return
def add(a:Int, b:Int) = {
  val result = a+b
  println(result) //sideeffect
  result //dont have to write return!
}

add(5,10)
add(500,210)

def mult(a:Int, b:Int) = {
  //in Scala the last line is returned automatically
  a*b
}

mult(6,10)+10+100

def multAny(a: Double, b:Double): Int={
  (a*b).toInt
}
multAny(9.11,3.14)
multAny(10,2)

def addAndMultiply(a: Double, b:Double, c:Double)= {
  add(multAny(a,b),multAny(b,c))
}

val myResult = addAndMultiply(3,4,5)
println(myResult)

//Anti-pattern ! do not mutate outside variables
var myMutable = 10
//you cant tell if mutateOutside is correct or not
def mutateOutside()= {
  myMutable += 5
  println(myMutable)
}
mutateOutside()
mutateOutside()
mutateOutside()

//Instead you should be doing this
def add5(a: Int) = {
  a+5 //remember last line is returned automatically no need for return
}

myMutable
myMutable = add5(myMutable)
myMutable = add5(myMutable)
myMutable = add5(myMutable)
myMutable

//Platonic goal is to have a program with pure functions
//pure function is one without sideeffects(modifiying something)

println(add5(10))
add5(20) == 25

//make a functions which RETURNS! reversed and uppercase string (so input string and output string)
def getReversedUpper(text:String):String = {
  //  println(s"Going to reverse: $text")
  //I could do stuff here and it will not be returned
  text.toUpperCase.reverse
}

def getStringLength(text:String):Int = {
  //myLocal is local to this function between its curly braces
  //in programming you call it scope
  val myLocal = text.length
  //more code goes here between curly braces
  myLocal
}

getReversedUpper("Beer")
getReversedUpper("Valdis") == "SIDLAV"

getStringLength("Valdis")

//common pattern create local result variable then return at the end
def getResults(a:Int, txt:String) : Int = {
  var result = 0
  result = a * txt.length
  result += 1000 //result = result + 1000
  result //last line is what gets returned
}

getResults(10, "Valdis")


def getMax(a:Int, b:Int)= {
  var result = 0
  if (a>b) {
    //scope for myName is local to inner curly braces!!
    result = a
  } else {
    result = b
  }
  //maybe i need to do more stuff here and only then
  //i would return the last line with the result
  result
}

getMax(10,20)
getMax(5,3)
//a is global for this notebook
val a = 5
if (a == 2*2) {
  println("A is 4")
} else {
  println("A is not 4")
}

//for functions which return booleans we prefix isSomething
def isEqualTo4(a:Int): Boolean = {
//  if (a == 2*2) {
//   true
//  } else {
//    false
//  }
  //shorter is simply
  a == 2*2
}
isEqualTo4(4)
isEqualTo4(5)

5 > 2*2
4 >= 2*2 //larger or equals
4 != 5
4 != 4
4 <= 2*2
4 < 5
val myName = "Valdis"
if (myName == "Valdis") {
  println("Wow that is my name too!")
}
println("This happens all the time")
def checkName(myName:String, friendName:String) = {
  var isSame = false
  if (myName == friendName) {
    //we can do more stuff when names match
    println(s"Wow our names match perfectly my dear $friendName!")
    isSame = true
  } else {
    //we can do more stuff here if we want when our names do not match
    println(s"Well my name $myName is a bit different from your name $friendName...")
    isSame = false
  }
  println("Let's be friends no matter what!")
  isSame //we could skip isSame and just do myName == friendName
}

checkName("Valdis", "Liga")
checkName("Valdis", "Valdis")
//just a comment

//ifs in Scala return something always!!
if (true) {
  //do this
} else {
  //do this
}

!true
!false

val myMax = 20
