val a = 2
if (a == 0) println("a is 0")
else if (a == 1) println("a is getting to be 1")
else if (a == 2) println("a is getting to be 2")
else if (a == 3) println("a is getting to be 3")
else if (a == 4) println("a is getting to be 4")
else println("what is this?")

a==0
a==1
a==14
a==15

val result = {
  a match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }
}
println(result)

val text = "Valdis"

val myNum =   text match {
  case "Anna" => 1000
  case "Liga" => 2000
  case "Valdis" => 9000
  case "Peteris" => 2500
  case _ => -1
}

println(myNum)

println(text match {
  case "Anna" => 1000
  case "Liga" => 2000
  case "Valdis" => 9000
  case "Peteris" => 2500
  case _ => -1
})

def matchTest(x: Int): Any = x match {
  case 1 => "one"
  case 2 => "two"
  case 3 => 30
  case _ => "other"
}

println(matchTest(33232))
println(matchTest(3))
println(matchTest(2))

def anyMatch(x: Any): Any = x match {
  case 1 => "one"
  case 2 => "two"
  case 3 => 30
  case "Valdis" => 30
  case _ => "other"
}

println(anyMatch(2))
println(anyMatch("Valdis"))

//write a function to return 1 to 4 as words and 5 as number and anything as "error"
def only4(incoming: Any):Any = incoming match {

  case _ => "Error"
}

println(only4(1))
println(only4(10))
println(only4(incoming = 20))
println(anyMatch(x = 20))

def prettyPrint(anyItem: Any):Unit= {
  println(s"Just a pretty print of $anyItem")
}

def lazyPow(a:Int, b:Double = 2, isPrettyPrint:Boolean = false,multiplier:Int = 10) :Double = {
  if (isPrettyPrint) prettyPrint(Math.pow(a,b))
  Math.pow(a,b)*multiplier
}

lazyPow(10)
lazyPow(10,3)
lazyPow(10,0.5)
lazyPow(10,5,isPrettyPrint = true, 1)
//lets see if we can skip the second argument
lazyPow(10,isPrettyPrint = true)
lazyPow(10,isPrettyPrint = true, multiplier=1)