import scala.collection.immutable.{ListMap, TreeMap}

val map = scala.collection.mutable.HashMap.empty[Int,String]
map += (1 -> "make a web site")
map += (3 -> "profit!")
map(1)
map += (33 -> "learn")
map += (63 -> "relax")
map.foreach(println)

val listMap = ListMap(map.toSeq.sortBy(_._1):_*)
val listMapVal = map.toSeq.sortBy(_._2)
listMapVal.toMap
//listMap(2) will not work because its a ListMap not List (with index)
listMap(3)
listMap.foreach(tup => println(s"${tup._1} ${tup._2}"))
var newListMap = ListMap(("a" -> "AA"))
newListMap += "b" -> "BBBB"
newListMap += "c" -> "CBBBB"
newListMap += "e" -> "ieeee"
newListMap += "d" -> "ieeeedddee"
newListMap
newListMap("d")

//so TreeMap gives you keys in guaranteed sorted order and keeps that way
//again if you do not need this sorting ahead of time, just use Map
var newTreeMap = TreeMap("anton" -> "chekhov", "fyodor" -> "dostoyevsky", "aleksey" -> "tolstoy", "charles" -> "dickens")
newTreeMap

//You can do everything with just Map and Seq (with a little bit of Set)

val names = Seq("Valdis","Liga","Maija", "Martins","Ruta")

//TODO create a Map out of names with keys the individual names and values their length
//TODO see if you can make TreeMap instead :)




