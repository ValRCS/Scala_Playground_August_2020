package com.github.valrcs

object EnvVars extends App {
  val environmentVars = System.getenv()
  val sqlite_home = environmentVars.get("SQLITE_HOME")
  println(sqlite_home)
}
