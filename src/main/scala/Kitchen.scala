object Kitchen extends App {
  println("Starting to Cook!")
  //create 3 recipe Objects and cook them! :)
  val salad = new Recipe("Summer Salad", Seq("tomatoes", "sour cream","onions","paprika"), Seq("cut into pieces", "mix", "chop"), 5)
//  salad.printIngredients()
//  salad.tupIngredients.foreach(println)
//  val jobs = salad.cook(salad.tupIngredients, Seq("cut into pieces", "mix", "chop"))
  val jobs = salad.superCook()
  println(jobs)
  val soup = new Recipe("Borsch", Seq("beets","onions","beefstock","carrots"), Seq("cut","chop","split","boil","extra rinse"), 90)
  println(soup.superCook())
}
