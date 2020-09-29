import java.sql.{DriverManager, PreparedStatement}

import com.github.valrcs.collections.Contact

/**
 */
object CreateDB extends App {

  val environmentVars = System.getenv()
  environmentVars.forEach((k,v) => println(k,v))
  println("SCALA_HOME", environmentVars.get("SCALA_HOME"))
  println("SQLITE_HOME", environmentVars.get("SQLITE_HOME"))
//  for ((k,v) <- environmentVars) println(s"key: $k, value: $v")

  val properties = System.getProperties()
//  for ((k,v) <- properties) println(s"key: $k, value: $v")
    val sqlite_home = environmentVars.get("SQLITE_HOME").replace("\\", "/")
    println(sqlite_home)
  val dbname = "phone.db"
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
      |	email TEXT NOT NULL ,
      |	phone TEXT NOT NULL
      |);
      |""".stripMargin

  val statement = conn.createStatement()
  val resultSet = statement.execute(sql)

  val person1 = Contact(1, "John", "Smith", "john.smith@gmail.com", "888223408")
  val person2 = Contact(2, "Mary", "Simpson", "mary.simpson@gmail.com", "885993500")
  val person3= Contact(3, "Homer", "Simpson", "homer.simpson@gmail.com", "885993500")
  val persons = Seq(person1, person2, person3)
  persons.foreach(println)

  /**
   *
   */
  val insertSql =
    """
      |INSERT INTO contacts (
      |first_name, last_name, email, phone)
      |VALUES(?,?,?,?)
      |""".stripMargin

  val preparedStatement = conn.prepareStatement(insertSql)
  for (p <- persons) {
//    preparedStatement.setInt(1, p.contact_id)
    preparedStatement.setString(1, p.first_name)
    preparedStatement.setString(2, p.last_name)
    preparedStatement.setString(3, p.email)
    preparedStatement.setString(4, p.phone)
    preparedStatement.addBatch
  }

  // so this below is same as above 5 lines
  persons.foreach(setPerson(preparedStatement, _))
  preparedStatement.executeBatch()

  preparedStatement.close()

  /**
   *
   * @param preparedStatement
   * @param person
   */
  def setPerson(preparedStatement: PreparedStatement, person:Contact) = {
      preparedStatement.setString(1, person.first_name)
      preparedStatement.setString(2, person.last_name)
      preparedStatement.setString(3, person.email)
      preparedStatement.setString(4, person.phone)
      preparedStatement.addBatch
  }


}
