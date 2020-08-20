object Tree extends App {
  //print a tree preferably given command line argument (or read it from user input)
  //provide a default of 3 if no argument is given
  //3 would be nicer to use val instead of var to get the argument
  //  *
  // ***
  //*****
  var treeH = 3
  if (!args.isEmpty) treeH = args(0).toInt
  println(s"ready to make my tree $treeH high")
//  for (i <- 1 to treeH) {
//    print(" "*(treeH-i))
//    println("*"*(i*2-1))
////    println(" "*(treeH-i) + "*"*(i*2-1))
//  }
//  val result = Range(1,treeH+1).map(n => " "*(treeH-n)+ "*"*(n*2-1))
//  result.foreach(println)
//  println(result.getClass)
  Range(1,treeH+1).map(n => " "*(treeH-n)+ "*"*(n*2-1)).foreach(println)
  Range(1,5).map(num => num*10).foreach(println)



}
