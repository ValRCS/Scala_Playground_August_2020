val mySeq = Seq(1,2,3,5,6,8)
mySeq(1)
mySeq.slice(2,4)
mySeq.filter(_ > 3)
mySeq.map(n => n * n * n)
mySeq.foreach(n => println(s"This is number $n"))

for (n <- mySeq) {
  //for working with more complicate stuff
  println(n*n)
  //you will probably want to mutate something here :)
}