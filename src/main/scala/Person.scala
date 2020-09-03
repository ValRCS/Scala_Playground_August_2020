class Person(var firstName: String, var lastName: String, var age:Int) {
  //function inside class that's a method
  private var fullName = s"$firstName $lastName"
  //if it is not private it is public!!
  val votingAge = 18
  var isVoter = false //we could have done logic here but danger is that complicated logic should only reside in one place
  private var accessCounter = 0
  def prettyPrint() = println(s"$firstName, and also $lastName, aged: $age")
  def isEligible(): Boolean ={
    if (age >= votingAge) {
      isVoter = true
    } else {
      isVoter = false
    }
    isVoter
  }
  //setter
  def setLastName(newLastName:String): this.type = {
    lastName = newLastName
    updateFullName()
    this
  }

  def setAge(newAge:Int): this.type = {
    age = newAge
    this
  }
  //make a setter for first name which also returns this

  def setFirstName(newFirstName:String): this.type = {
    firstName = newFirstName
    updateFullName()
    this
  }

  private def updateFullName() = fullName = s"$firstName $lastName"

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
