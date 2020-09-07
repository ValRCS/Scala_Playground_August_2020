import scala.collection.mutable.Queue
// A queue is a first-in, first-out (FIFO) data structure.

var ints = Queue[Int]()
var fruits = Queue[String]()
var q = Queue[Person]()

fruits += "apple"
fruits += "lemon"
fruits += "pear"
println(fruits)
fruits ++= Seq("banana","apricot")
fruits
fruits.enqueue("forbidden fruit")
fruits
val next = fruits.dequeue()
next
fruits
println(fruits.dequeue())
fruits
// no need for this
// fruits.zipWithIndex.filter(t => t._2 < 3).map(t => t._1)
//so just like a regular sequence
fruits.slice(0,3) //this only returns but does not destroy
fruits

val first3 = for {
  i <- 0 to 2
  item = fruits.dequeue()} yield item
first3
fruits

q.enqueue(new Person("Valdis","S", 150))
q.enqueue(new Person("Liga","S", 150))
q.enqueue(new Person("Maija","S", 150))
q.enqueue(new Person("Youngster","S", 15))
q.enqueue(new Person("Ruta","S", 15))
q.count(_.age > 100) //this will work with any sequence
val firstPerson = q.dequeue()
firstPerson.prettyPrint()
val teenagers = q.dequeueAll(_.age < 19) // just like filtering except q is modified
teenagers.foreach(_.prettyPrint())
q.foreach(_.prettyPrint())
