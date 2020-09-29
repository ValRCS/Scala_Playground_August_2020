package com.github.valrcs

/**
 *
 * @param contact_id
 * @param first_name
 * @param last_name person's last name
 * @param email
 * @param phone
 */
final case class FirstContact(contact_id: Int,
                              first_name: String,
                              last_name: String,
                              email: String,
                              phone: String) {
  def printMe() = {
    println(s"$first_name and $last_name with phone $phone")
  }
}
