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




