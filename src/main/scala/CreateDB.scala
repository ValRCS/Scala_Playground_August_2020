import java.sql.DriverManager


object CreateDB extends App {

  val environmentVars = System.getenv()
  environmentVars.forEach((k,v) => println(k,v))
  println("SCALA_HOME", environmentVars.get("SCALA_HOME"))
  println("SQLITE_HOME", environmentVars.get("SQLITE_HOME"))
//  for ((k,v) <- environmentVars) println(s"key: $k, value: $v")

  val properties = System.getProperties()
//  for ((k,v) <- properties) println(s"key: $k, value: $v")
    val sqlite_home = environmentVars.get("SQLITE_HOME").replace("\\", "/")

  val dbname = "really_newone.db"
  println(s"Creating DB $dbname")
  val url = s"jdbc:sqlite:$sqlite_home/db/$dbname"

  val conn = DriverManager.getConnection(url)

  //lets make a table!
  val sql =
    """
      |CREATE TABLE IF NOT EXISTS contacts (
      |	contact_id INTEGER PRIMARY KEY,
      |	first_name TEXT NOT NULL,
      |	last_name TEXT NOT NULL,
      |	email TEXT NOT NULL UNIQUE,
      |	phone TEXT NOT NULL UNIQUE
      |);
      |""".stripMargin

  val statement = conn.createStatement()
  val resultSet = statement.execute(sql)



}
