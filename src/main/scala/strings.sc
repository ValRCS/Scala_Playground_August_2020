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