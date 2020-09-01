import java.util.Calendar

import scala.util.Random

//case class means all parameters are vals
//you also get pretty print for those parameters
//you get equality check and a few other things compared to regular class
case class Car(make: String, year: Int, model: String) {
  var mod = ""
  private var miles = 0
  Random.setSeed(9000)//since random is actually pseudorandom
  //purpose of seed is to provide same pseudorandom values across different computers
  private val currentYear = Calendar.getInstance().get(Calendar.YEAR)
  def modifyCar(new_mod:String) = mod = new_mod
  def rideTheCar() = println(s"Riding my car $model")
  def addMiles(driven:Int) = {
    if (driven > 0)
      miles+=driven //changeMileage
  }
  def getInitMiles() = {
    10000 + Random.between(5000,25000) * (currentYear-year)
  }
  def getMiles()=miles

  def init() ={
    miles = getInitMiles()
    //do more initialization here
  }
  init()
}
