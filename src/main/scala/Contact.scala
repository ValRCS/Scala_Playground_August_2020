package com.github.valrcs.collections

/**
 *
 * @param contact_id
 * @param first_name
 * @param last_name
 * @param email
 * @param phone
 */
final case class Contact(contact_id: Int,
      first_name: String,
      last_name: String,
      email: String,
      phone: String)
