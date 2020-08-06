val myName = "Valdis" //string is implicit
println(myName)
myName.length
myName(0)
myName(1)
5 > 2*2
res2 > res3
"V" > "a"
"V" > "A"
"A".getClass
'A'.getClass
'A'.toInt
'V'.toInt
'a'.toInt
'ā'.toInt
'č'.toInt
'?'.toInt
val c = 'ā'
println(c)
val first3 = myName.take(3)
println(first3)
val last3 = myName.drop(3)
last3
val myFood = "potatoes"
myFood.slice(3,7) //notice that index 7 is not included
myFood(7)
//first real chaining example
myFood.toUpperCase.take(6).slice(1,4)

//equality
4 == 2*2
2*2 == 4
val a = 4
a == 4
a == 20

myFood == "paste"
myFood == "potatoes"
val myOtherFood = "potatoes"
myFood == myOtherFood

//building a string from other strings
//string interpolation makes it easy to build strings from other strings

println(s"My names is $myName and I really like $myFood")

val myNumber = 77
val myPI = 3.14159

println(s"My names is $myName and I really like $myFood since $myNumber .Thank You!")
println("My names is $myName and I really like $myFood since $myNumber .Thank You!")

println(s"My pie is very tasty and is round $myPI")

myFood.foreach(println) //really concise way of doing something to each character in a string

myFood.toUpperCase.foreach(println)

val otherFood = "potata"

myFood intersect otherFood

myFood diff otherFood

myFood.distinct //all unique

res35+res36
//below makes it easier not to miss any whitespace
s"$res35 ***** $res36"

myFood.count(_ == 'o')

val myMagic = "abrakadabra"
myMagic.count(_ == 'a')

myMagic.replace("abra", "oxxo")

//first match
myMagic.indexOf('r')
myMagic.indexOf("r")

myMagic.indexOf("aka")