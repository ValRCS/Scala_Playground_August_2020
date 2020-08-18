object ParseArgs extends App {
  var treeHeight = 3
//  if (!args.isEmpty)

//  if (args.length > 0) {
  if (!args.isEmpty) {
    println(s"We got ${args.length} argument")
    treeHeight = args(0).toInt
  } else
    println("We got nothing well we will use the default value")

  println(s"my Default value is $treeHeight")

  for (i <- 1 to treeHeight)
    println(" "*i + "*"*i)
}
