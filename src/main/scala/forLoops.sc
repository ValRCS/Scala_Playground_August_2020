import java.io.File
import java.nio.file.Paths
//for loops are for iterating through something many times
//to should be including last value
for (i <- 1 to 5) {
  println(s"i is $i")
}
//i is gone here

//until is excluding last value
// new i is made inside
for (i <- 1 until 5 ) {
  println(s"i is $i")
}
//i is gone here as well
//println(i)
for (i <- 1 until 5 by 2) {
  println(s"i is $i")
}

//using for loop print all even numbers from 2 to 10 including
for (i <- 2 to 10 by 2) {
  println(s"i is $i")
}

//for loops will work for any iterable collection
for (i <- Array(10,20,30)) {
  println(s"i value is $i")
}
//i is gone from memory here

val myFiles = new File(".").listFiles()
for (file <- myFiles) println(file)
//remember file is gone now

println(Paths.get(".").toAbsolutePath)

//hard coded path in Windows (Mac and Linux would have / instead of \\
val myGitHubDir = new File("C:\\Users\\val-p1\\Scala_Test\\src\\main\\scala").listFiles()
for (file <- myGitHubDir) println(file)

new File("C:/Users").listFiles().foreach(println)

Array(10,20,30).foreach(println)
//foreach is nice for doing smaller things one or two lines
Array(10,20,30).foreach(item => println(s"Answer is $item"))
//item is gone here it was created for looping through above

for (item <- Array(10,20,25)) println(s"Answer is $item")

val arr = Array(10,20,26,42)
//not Scala style, this is old C style
//this is more dangerous because you could make an off by one error
//for (i <- 0 until arr.length) {
//  println(s"Element with index $i is ${arr(i)}")
//}
//if you do need index then use indices!!
for (i <- arr.indices) {
  println(s"Element with index $i is ${arr(i)}")
}



def prettyPrint(anytype: Any):Unit= {
  println(s"Just a pretty print of $anytype")
}

prettyPrint("Valdis")

val myTexts = Seq("Valdis","Ruta","Liga","Peteris")


myTexts.foreach(prettyPrint)
arr.foreach(prettyPrint)
for (element <- arr) {
  println(s"I could something else with $element")
  prettyPrint(element)
}

for (element <- arr if element > 25) {
  println(s"Nice element $element")
}

print("*")
print(" ")

print(" "*5)
print("*"*3)
//you can use something like this
//maybe somebody can find another syntax
print(" "*3 + "*"*5)

