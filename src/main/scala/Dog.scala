class Dog(name:String, val bark:String) extends Animal(name=name) {
  def make_noise() = println(s"$bark !")
}
