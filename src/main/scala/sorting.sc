import scala.util.Random

val myData = Seq(1,2,5,6,7,7,2,1,6,7,10)
//val myRandoms = Range(1,20).map(n => (Math.random()*20).toInt )
//if our mapping is not using the item we use underscore
val myRandoms = Range(1,20).map(_ => Random.between(1, 20+1))
myRandoms
myRandoms.sorted
myRandoms.sorted.reverse

val myTexts = Seq("Valdis", "Liga", "Maija", "Abracadabra", "Voldemars")
myTexts.sorted
// so sortWith function has the signature two strings returns Bool
myTexts.sortWith(_.length > _.length)

myTexts.sortWith(_.length < _.length)
// the above is a shorthand for the below function
myTexts.sortWith( (arg1, arg2) => arg1.length < arg2.length)