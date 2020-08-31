object Restaurant extends App{
  val cook = new Cook()
  cook.prettyPrint()
  cook.make_a_muffin()
  val pet = new Animal("Tom")
  val jerry = new Mouse("Jerry") //we want to instantiate a mouse class that extends animal
  pet.prettyPrint()
  jerry.squeek()
  jerry.prettyPrint()
  val doggie = new Dog("Fluffy", "woof woof")
  doggie.make_noise()
  val mice = Range(1,10).map(n => new Mouse(s"Mice No. $n"))
  mice.foreach(_.squeek())
}
