trait Cooking {
  //to keep things simple we only have instructions in pairs
  def cook(ingredients: Seq[(String,String)], instructions: Seq[String]):String
}
