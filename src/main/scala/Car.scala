case class Car(make: String, year: Int, model: String) {
  var mod = ""
  def modifyCar(new_mod:String) = mod = new_mod
  def rideTheCar() = println(s"Riding my car $model")
}
