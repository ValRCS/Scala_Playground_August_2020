object FoodCalculator extends App {
  val food = "potatoes"
  val price = 0.37
  val quantity = 20
  var myVar = 50
  println(s"We got ${args.length} arguments")
  println(s"The first argument is ${args(0)}")
  println(s"The second argument is ${args(1)}")
  println(s"The third argument is ${args(2)}")

  myVar += 100
  myVar += 100
  val cost = args(0).toFloat * args(1).toInt
  //println how much will it cost to buy the food
  //It will cost XXXX to buy XX kilos of XXXX
  println(s"It will cost $cost Euros to buy ${args(1)} kilos of ${args(2)}")
  //something
  println("All done")
}
