def print2() = {
  println("One Line")
  println("Second Line")
}
print2()
print2()

//Unit is basically an empty return
def add(a:Int, b:Int) = {
  val result = a+b
  println(result) //sideeffect
  result //dont have to write return!
}

add(5,10)
add(500,210)

def mult(a:Int, b:Int) = {
  //in Scala the last line is returned automatically
  a*b
}

mult(6,10)+10+100

def multAny(a: Double, b:Double): Int={
  (a*b).toInt
}
multAny(9.11,3.14)
multAny(10,2)

def addAndMultiply(a: Double, b:Double, c:Double)= {
  add(multAny(a,b),multAny(b,c))
}

val myResult = addAndMultiply(3,4,5)
println(myResult)

//Anti-pattern ! do not mutate outside variables
var myMutable = 10
//you cant tell if mutateOutside is correct or not
def mutateOutside()= {
  myMutable += 5
  println(myMutable)
}
mutateOutside()
mutateOutside()
mutateOutside()

//Instead you should be doing this
def add5(a: Int) = {
  a+5 //remember last line is returned automatically no need for return
}

myMutable
myMutable = add5(myMutable)
myMutable = add5(myMutable)
myMutable = add5(myMutable)
myMutable

//Platonic goal is to have a program with pure functions
//pure function is one without sideeffects(modifiying something)

println(add5(10))
add5(20) == 25


