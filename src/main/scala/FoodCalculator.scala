object FoodCalculator extends App {

  var price = 0.37
  var quantity = 20
  println(s"We got ${args.length} arguments")
  //! means negation
//  if (!args.isEmpty)
  if (args.length >= 2) {
    price = args(0).toFloat
    quantity = args(1).toInt
  }
  val food = if (args.length >= 3) args(2) else "potatoes"

  if (args.length >= 3) {
    println(s"The first argument is ${args(0)}")
    println(s"The second argument is ${args(1)}")
    println(s"The third argument is ${args(2)}")
  }

  //For rounding https://stackoverflow.com/questions/11106886/scala-doubles-and-precision
  val cost = BigDecimal(price * quantity).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  //println how much will it cost to buy the food
  //It will cost XXXX to buy XX kilos of XXXX
  println(s"It will cost $cost Euros to buy $quantity kilos of $food")
  //something
  println("All done")
}
