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

myTexts.sortBy(_.length)
// above is the same as this
myTexts.sortBy(item => item.length)

//tiny exercise sort the text by 2nd letter only
myTexts.sortBy(t => t(1))
myTexts.sortWith( (a, b) => a(1) < b(1))
//so below is not going to be quite right
// because we ask for both 2nd AND 3rd letter to be correct
myTexts.sortWith( (a, b) => a(1) < b(1) && a(2) < b(2))
myTexts.sortBy(t => (t(1), t(2)))
// So we sort by second letter and if equal then 3rd by length
Seq("_BC","_BB__","_BB","_BB____","_BD", "_AD").sortBy(t => (t(1), t(2), t.length))

//rarely used you can actually pick the algorithm,
// only important if the original order is import
//val fruits = Array("cherry", "apple", "banana")
//fruits.sorted
//val sortedFruits = fruits.sorted.reverse
//scala.util.Sorting.quickSort(fruits)
//fruits
//scala.util.Sorting.stableSort(myTexts)