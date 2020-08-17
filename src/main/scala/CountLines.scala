import scala.io.Source

//will count lines from first files given as argument
object CountLines extends App{
  //read arg
  //read text file
  //loop through each line and count length
  //keep a running total of all characters
  println("Running CountLines")
  if (args.length > 0) { //at least one file
    for (arg <- args) {//for each argument in our arguments do the below loop
      println(s"Working now on file $arg")
      println("*"*40)
      //then we start the inner loop for each file
      for (line <- Source.fromFile(arg).getLines())
        println(s"${line.length.toString}::: $line")
    }

  } else {
    println("You need to enter file as command argument")
  }
  //TODO
  //print the length of the longest line
  //BONUS print the longest line itself
}
