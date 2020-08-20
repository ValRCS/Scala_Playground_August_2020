// reducing something means we go over collection and we are going to pass a function which has two! arguments and returns one

val myNumbers = Range(1,6)
myNumbers.foreach(println)
myNumbers.sum
//regular programming for sum would be as follow
var mySum = 0
for (n <- myNumbers)
  mySum += n
println(s"Sum is $mySum")
myNumbers.reduce((a,b) => a+b)
myNumbers.reduce((a,b) => a*b) //should be factorial

def adder(a: Int, b: Int): Int = {
  val theSum = a+b
  println(s"got a:$a, b:$b => result $theSum")
  theSum
}
myNumbers.reduce(adder)

val myTexts = Seq("ABBA","friend","hello")
myTexts.map(t => t.length).sum

val myFloats = myNumbers.map(n => n.toFloat)
myFloats.reduce((acc, num) => acc / num )
myFloats.reduce((acc, num) => num / acc )
