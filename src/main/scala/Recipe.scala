//make a class of Recipe which name as String
//ingredients as Seq(Strings)
//instructions as Seq(Strings)
//cooking time as Int

//if we are not using var or val then it is val
//if you want to make them mutable thats fine too
class Recipe(name: String, ingredients: Seq[String], instructions: Seq[String], cookTime: Int) extends Cooking {
  def printIngredients() =
    for (item <- ingredients) {
      println(item)
    }
  def getTupSeq(): Seq[(String, String)] = {
    //you can zip two parts together
    val mySeq =  ingredients.slice(0,ingredients.size-1) zip ingredients.slice(1,ingredients.size)

    mySeq
  }
  def superCook():String = {
    val tasks = cook(tupIngredients, instructions) //we use our internal instructions
    s"Recipe for:\n$name\n\n$tasks\n\nTakes $cookTime minutes to make."
  }


  override def cook(tupIngredients: Seq[(String, String)], instructions: Seq[String]): String = {
    val todos  = tupIngredients zip instructions // so zip actually works up to shortest sequence
//    todos.foreach(todo => println(s"Take ${todo._1._1} then ${todo._2} with ${todo._1._2} "))
    val textInstructions = todos.map(todo => s"Take ${todo._1._1} then ${todo._2} with ${todo._1._2} ")
    textInstructions.mkString("\n")
  }
  val tupIngredients = getTupSeq()
}
