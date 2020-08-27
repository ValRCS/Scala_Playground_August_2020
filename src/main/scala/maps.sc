import scala.collection.{SortedMap, mutable}

val myMap = Map("name" -> "Valdis", "job" -> "teaching", "loves" -> "teaching")
myMap("name") //this lookup will be instant!!
//think of a big haystack with needles
//or better as a dictionary with an index where to go
val mySeq = Seq(("name","Valdis"),("job","teaching"))
myMap("loves")
//you can't have more than one key of same name
//means you must have unique keys in your map
val myGeneralMap = Map("name" -> "Valdis", "speed" -> 100,"name"-> "Saule")
myGeneralMap("speed")
myGeneralMap.values
myMap.values.foreach(println)
myMap.keys.foreach(println)

//we can go through all of myMap one key and value at a time
for ((key,value) <- myMap) {
  println(s"Key: $key, Value: $value")
  // do more stuff with each key and value
}

var newMap = myMap + ("food" -> "potatoes") //how we would work with adding new values
newMap += ("hunger" -> "growing")
newMap
//so we can use keys to delete our key, value pairs

newMap -= "food" //this is same as newMap = newMap - "food"
newMap += ("drinks" -> "water, wine")
newMap
newMap.size
newMap.toSeq(1) //2nd element
newMap.toSeq(1).getClass
val myNewSeq = Seq("Valdis","Liga", "Maija")
//here we created mapping on the fly
val convertedMap = myNewSeq.map( a => a -> a(0)).toMap
convertedMap
//here we give a sequence of tuples (string,string)
Seq(("name","valdis"), ("food","potatoes")).toMap
newMap
newMap -= "drinks"
newMap

//given text Chocolate and Cocoa Recipes and Home Made Candy Recipes by Hill and Parloa"
//create Sequence with all words
//create Map mapping word -> word length

//generally you do not need to worry about sorting early
//so use SortedMap sparingly because sorting is expensive
val sortedMap = SortedMap("food"->"rice","drink"->"water","car"->"VW")
sortedMap
sortedMap.toSeq(2)
sortedMap.toSeq(2)._2 //you can convert to Seq and then get invididual elements
sortedMap("food") //if you know you'd use key of course

//if we need to remember the insertion order then we would use LinkedHashMap
//there is performance penalty over regular Map
var myMemoryMap = mutable.LinkedHashMap("name"->"Valdis")
myMemoryMap += ("buy" -> "milk")
myMemoryMap += ("eat" -> "chocolate")
myMemoryMap -= "buy"
myMemoryMap += ("buy" -> "milk")
//you can add a full map
myMemoryMap ++= Map("sell" -> "gnomes", "pickup" -> "kids")
myMemoryMap ++= myMap
myMemoryMap

//challenge map
val aText = "Chocolate and Cocoa Recipes and Home Made Candy Recipes by Hill and Parloa"
val aSeq = aText.split(" ").toSeq
val aMap = aSeq.map(word => word -> word.length).toMap
aMap.foreach(println)

//so we add Type to our map since we start with Empty Map
var mutMap: mutable.Map[String,String] = mutable.Map()
//var mutMap = mutable.Map(""->"") //to avoid this
for ((k,v) <- myMemoryMap)
  mutMap += (k.toUpperCase -> v)
mutMap

//this can break if there is no map
//https://stackoverflow.com/questions/9130368/map-both-keys-and-values-of-a-scala-map
val freshMap = myMemoryMap.map({
  case (key,value) => (key.toUpperCase, s"$value :: ${value.length}")
})
freshMap

var topValue = ""
var topKey = ""
for ((k,v) <- mutMap) {
  if (v.length > topValue.length) {
    topValue = v
    topKey = k
  }
}
println(s"Winning key is $topKey with value $topValue")

//TODO would to find a way of filtering MAP without loop



