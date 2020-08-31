class Person(val fixedFirstName: String, var lastName: String, var age:Int, var isVoter: Boolean = true) {
  //function inside class that's a method
  private var fullName = s"$fixedFirstName $lastName"
  //if it is not private it is public!!
  val votingAge = 18
  private var accessCounter = 0
  def prettyPrint() = println(s"$fixedFirstName, and also $lastName, aged: $age")
  def isEligible(): Boolean ={
    if (age >= votingAge) {
      isVoter = true
    } else {
      isVoter = false
    }
    isVoter
  }
  //setter
  def setLastName(newLastName:String): Unit = {
    lastName = newLastName
    fullName = s"$fixedFirstName $lastName"
  }

  def getFullName() = {
    accessCounter += 1 //this is private var outside does not see it!!
    fullName
  }

  def getStats() = println(s"Full Name was accessed $accessCounter times")

  def growUp(years:Int): Unit = {
    age += years
    secretFun()
    isEligible()
  }

  //idea behind private functions and variables is to expose publicly only what is needed
  private def secretFun() = println("Secret Fun")
  //this will run one time when we construct(initialize) our new person objct
  isEligible()
  println(s"Constructor is done for  $fullName !")
}
