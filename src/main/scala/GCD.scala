import scala.io.StdIn.readLine

object GCD extends App{
  var i = 0 //i usually stands for iterator
  //the while loop runs while i < 10 == true
  while (i < 10) {
    println(i) //println is a slow operation avoid it whenever possible
    i+=1 //i = i + 1 //otherwise we would run this program forever
  }
  println(s"i is $i")

  var sum = 0.toLong
  i = 0
  val max = 1000.toLong
//  println("How far do you want to count?")
//  val max = readLine().toLong
  while (i <= max) {
    sum += i  //add whatever i is at the time to sum
    i+= 1 //add 1 to iterator
  }
  println(s"Sum of numbers up to and including $max is $sum")
  println(s"Lazy Gauss would have solved it like this ${max*(max+1)/2})")

  //do while loops are rarest they do something and only then check if they should continue
  i = 42
  do {
    println(s"i is $i")
    i -= 1 // i = i - 1
  } while (i > 45)
  println(s"i is $i")

  //algorithm for the greatest common divisor
  // https://en.wikipedia.org/wiki/Euclidean_algorithm
  def gcdLoop(x: Long, y:Long):Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a //we saved a since we going to mutate this a
      a = b % a  //new a is now whatever remains when we divide b by a
      b = temp // move old a to b
    }
    b //we return the value
  }

  //recursive method of getting gcd
  //recursive means referring to itself
  //like snake eating its own tail
  //use with caution
  def recursiveGCD(x: Long, y:Long):Long = if (y==0) x else recursiveGCD(y, x % y)

  println(gcdLoop(15,10))
  println(recursiveGCD(15,10))
  println(gcdLoop(12,10))
  println(gcdLoop(20,10))
  println(gcdLoop(50,42))
  println(gcdLoop(24,18))
  println(recursiveGCD(24,18))
}




