val mySeq = Seq("Valdis","Līga","Maija","Voldemars", "Sophia")
mySeq.map(txt => txt.length).foreach(println)
mySeq.map(txt => txt.toUpperCase).foreach(println)
//exercise lets get only words longer than 5 letters long
//use filter
println("Printing only long names!")
val longCapitalNames = mySeq.filter(txt => txt.length > 5).map(txt => txt.toUpperCase)
longCapitalNames.foreach(println)