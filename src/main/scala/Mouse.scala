import com.github.valrcs.Animal

//when we extend an existing class we need to pass our construction arguments to them
class Mouse(name:String) extends Animal(name = name) {
  def squeek() = println(s"Squeee my name is $name, and also $name")
}
