import com.github.valrcs.Contact

object ErrorCheck extends App {
  println("Starting program")
  val a = 6
  var b = 10
  b += a
//  a += 10
  val numbers = Range(1,10).toList
  numbers.foreach(println)
  // turns out that using _ created mapping while using a real variable fixed the mapping
  val contacts = numbers.map(n => Contact(n, first_name = "name", last_name = "sun", email = "432@dfd.com",phone = "1188"))

  def contactPrint(contact:Contact) = {
    println(s"${contact.contact_id} ${contact.email} ${contact.first_name} you are good to go!")
  }
  contacts.foreach(println)
  println(contacts(5))
  contacts.foreach(contactPrint)
}

