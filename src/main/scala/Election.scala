object Election extends App {
  //we create an adam object based from Person class blueprint
  val adam = new Person("Adam","Sandler", 49)
  val tommy = new Person("Tom", "Sawyer", 12)
  println(adam.firstName) // we printed a property from this object
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

//  val youngOnes = people.filter(human => human.age < 40)
  val youngOnes = people.filter(_.age < 40)
  println(youngOnes.size)

  //get me all Eligible Voters
//  val allVoters =
//val allVoters = people.filter(human => human.isVoter == true)
//val allVoters = people.filter(human => human.isVoter)
val allVoters = people.filter(_.isVoter) //same as two lines above
  allVoters.foreach(_.prettyPrint())
  allVoters.foreach(human => println(human.getFullName()))

//find the longest last name among all people
  //first do it with a regular for loop
  //then try map and sort maybe

  val lastNamesSorted = people.sortBy(_.lastName.length)
  val longestLastName = lastNamesSorted.takeRight(1)
  lastNamesSorted.foreach(human => println(human.lastName))
  longestLastName.foreach(human => println(s"The longest last name is: ${human.lastName}."))

  println(s"Longest lastname is ${people.map(human => human.lastName.length).sorted.last} chars long")

  println(s"Longest is ${people.map(h => h.lastName).sortBy(_.length).last}")

  tommy.prettyPrint()
  tommy.setLastName("Tomster").setAge(55).prettyPrint()

  //change tommys first name to Al here before prettyPrint
  tommy.setLastName("Weird").setFirstName("Al").setAge(35).prettyPrint()

}
