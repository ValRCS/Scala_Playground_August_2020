object Election extends App {
  //we create an adam object based from Person class blueprint
  val adam = new Person("Adam","Sandler", 49)
  val tommy = new Person("Tom", "Sawyer", 12)
  println(adam.fixedFirstName) // we printed a property from this object
  adam.prettyPrint()
//  println(adam.fullName)
  println(adam.getFullName())
  adam.setLastName("Bungler")
  adam.prettyPrint()
  println(adam.getFullName())
//  adam.fullName = "not allowed"
//  adam.tempVariable = 9000 // tempVariable is private
//  println(adam.tempVariable)
//  println(adam.toString()) returns some data about the object
  println(tommy.isEligible())
  tommy.growUp(5)
  println(tommy.isEligible())
  tommy.prettyPrint()
  tommy.growUp(2)
  println(tommy.isEligible())
  tommy.prettyPrint()
//  val fields = tommy.getClass.getFields()
//  fields.foreach(element => println(getValue(element))
  val carol = new Person("Carol", "Smith", 27)
  val dave = new Person("Dave", "Smith", 16)
  println(tommy.getStats())
  println(adam.getStats())
  val people = Seq(adam, tommy, carol, dave)

  //print out the average age of all people
  var totalAge = 0
  for (human <- people) {
    println(human.age)
    totalAge += human.age
  }
  val avgAge = totalAge / people.size.toDouble
  println(s"Average age is $avgAge")
  println(people.map(_.age).sum / people.size.toDouble)

  val youngOnes = people.filter(human => human.age < 40)
  println(youngOnes.size)

  //get me all Eligible Voters
//  val allVoters =



}
