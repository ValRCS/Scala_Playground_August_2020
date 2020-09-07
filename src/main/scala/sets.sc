// set unordered collection of unique values
// unmutable set
val fruit = Set("apple", "orange", "peach", "banana", "apple")
println(fruit)

// mutable set
var mutSet = scala.collection.mutable.Set("apple","orange","apple")
println(mutSet)
mutSet += "Banana"
println(mutSet)
mutSet += "banana"
println(mutSet)
mutSet += "5000"
println(mutSet)

var grabBag = scala.collection.mutable.Set(5,6,"Valdis")
println(grabBag)
grabBag += 5
grabBag += 7
grabBag += "Regina"
println(grabBag)
println(mutSet.toSeq.sorted)
println(fruit.toSeq.sorted)
val charSet = "banana".toSet
println(charSet)
charSet.contains('b')
charSet.contains('d')
'a' == "a" // will always be false
'a'.getClass // char
"a".getClass // String

fruit
mutSet
val newSet = fruit.union(mutSet)
println(newSet)
val vegetables = Set("potatoes", "carrots")
val anotherSet = fruit ++ mutSet ++ vegetables
//so ++ is alias for union method
// diff is not idempotent meaning it works differently which set goes first
val diffSet = fruit -- mutSet //gets you values not in mutSet
val diffSet2 = mutSet.toSet -- fruit //gets you values NOT in fruit

