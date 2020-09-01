object CarShop extends App {
  val vw = Car("VW",2009, "Golf") //notice we did not need new here
  println(vw.toString) //so you get pretty print for free with case class
//  vw.make = "BMW" //will not work because case class parameters are val
val vw2 = Car("VW",2009, "Golf")
val vw3 = Car("VW",2010, "Golf")
  println(vw == vw2) //so case classes lets us compare two different objects
  println(vw == vw3) //false because of the different in one of the values
  val vw_clone = vw.copy()
  println(vw == vw_clone)
  vw match { case Car(m,y,t) => println(s"Car make is $m")}
  vw.rideTheCar()
  vw.modifyCar("Spoilers")
  println(vw)
  println(vw.mod)
  vw.
  //create 8 cars from years 2010 to 2018 all Hondas, models up to you
  //modify Car class to accept mileage this will be regular class variable(property)
  //because we want to change the mileage
  //add changeMileage method (method should only take positive change)
  //add currentMileage method
  val hondas = Range(2010,2018).map(Car("Honda",_,"CR-V")) // 9 not 8 Hondas
  println(hondas(3))

  //who can print all mileages for all hondas here?
  println(hondas(4).getMiles())

  for (car <- hondas)
    println(car.getMiles())

  hondas.foreach(car => println(s"${car.year} miles: ${car.getMiles()}"))


}
