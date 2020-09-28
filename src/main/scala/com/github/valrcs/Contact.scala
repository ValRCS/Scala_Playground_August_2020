package com.github.valrcs

/** Provides a blueprint for contact information
 *
 * State your assumptions here
 * Explain to user something which would not be obvious from class attribute names
 * Same goes for the types
 */
final case class Contact(contact_id: Int,
                         first_name: String,
                         last_name: String,
                         email: String,
                         phone: String)
