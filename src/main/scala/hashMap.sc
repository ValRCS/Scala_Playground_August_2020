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


val nmap = names.map(name => name -> name.length).toMap
//remember treeMap sorts by Keys
//val namesTreeMap = nmap.to(collection.immutable.TreeMap)
val namesTreeMap = TreeMap(nmap.toArray:_*)
val nArr = nmap.toArray

def add2(a:(String,Int), b:(String,Int)) : Int = {
  a._2 + b._2
}
println(add2(nArr(0), nArr(1)))
//println(add2(nArr.slice(0,2).toArray:_*))
//nArr.slice(0,2):_* //so _* only works in very specific circumstances
val newTMAP = TreeMap(nArr(0),nArr(1),nArr(2))
val newTMAP2 = TreeMap(nArr.slice(0,3):_*) //so it does work TreeMap and other data structure creation

//so Map,Set AND Seq all have foreach
nmap.foreach(item => println(s"${item._2}, ${item._1}"))
nmap.count(_._2 > 5)
nmap.count(t => t._1.startsWith("M") && t._2 > 5)
nmap.filter(t => t._1.startsWith("M") && t._2 > 5)
val iSeq = nmap.toIndexedSeq
iSeq(2) //for IndexedSeq types will be faster than LinearSeq

val foodSeq = IndexedSeq.fill(10)("potatoes")
// 2D table matrix with Seq of Seq
val nSeq = IndexedSeq.tabulate(5, 10)((n,o) => (n*n, o+o))
//so for small dataset Seq will go to List
val jSeq = Seq.tabulate(5, 10)((n,o) => (n*n, o+o))
nmap.head
nmap.headOption
Seq.empty.headOption

var mseq = scala.collection.mutable.Seq(10,20)
mseq
mseq.head
val result = mseq.headOption
val result = Seq.empty.headOption


result match {
  case Some(i) => println(s"result is $i")
  case None => println("Not good no data!")
}









