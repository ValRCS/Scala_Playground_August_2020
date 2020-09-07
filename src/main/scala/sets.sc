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
//so ++ actually adding the sets together which would work in the end the same as union
// diff is not idempotent meaning it works differently which set goes first
val diffSet = fruit -- mutSet //gets you values not in mutSet
val diffSet2 = mutSet.toSet -- fruit //gets you values NOT in fruit

val intersectSet = fruit.intersect(mutSet) //values common to both sets
// so & is alias to intersection
val intersectSet2 = mutSet.toSet & fruit
// so | is the real alias to union
val orSet = fruit | mutSet | vegetables

val bigNums = (1 to 10).toSet
val smallNums = (3 to 6).toSet
smallNums.subsetOf(bigNums)

def simDiff(s1: Set[Any], s2: Set[Any]):Set[Any] = {
  s1.diff(s2) | s2.diff(s1)
}

val medNums = (4 to 8).toSet
println(simDiff((3 to 6).toSet, (4 to 8).toSet))
println(smallNums.diff(medNums) | medNums.diff(smallNums))

//write a function which check if the sentence is a pangram
// "The quick brown fox jumps over a lazy dog" is a pangram
// https://en.wikipedia.org/wiki/Pangram

//find a list of ascii lower letters
val alphabet = ('a' to 'z').toSet
('a' to 'z').mkString("")

//def isPangram(sentence: String, alpha: String = "abcdefghijklmnopqrstuvwxyz" ): Boolean = {
//  //TODO create some set and compare them thats all :)
//  // we can make sets from strings with toSet
//
//  false //FIXME
//}

//sane default meaning English alphabet but if needed we can pass another language
def isPangram(sentence: String, alpha: String = "abcdefghijklmnopqrstuvwxyz"): Boolean = {
//  if (sentence.toSet == alpha.toSet) true else false
//  sentence.toSet == alpha.toSet // no need for the if
  alpha.toSet.subsetOf(sentence.toSet)
}

println(isPangram("waltz bad nymph for quick jigs vex"))
println(isPangram("waltz basck jigs vex"))
println(isPangram("waltz bad nymph for quick jigs vex TT "))