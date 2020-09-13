// https://www.sqlitetutorial.net/sqlite-sample-database/
// https://alvinalexander.com/scala/scala-jdbc-connection-mysql-sql-select-example/
// https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
// driver https://github.com/xerial/sqlite-jdbc

object DBTest extends App{
  println("Testing DB Connection!")
  val url = "jdbc:sqlite:C:/sqlite/db/chinook.db"

  import java.sql.DriverManager

  val conn = DriverManager.getConnection(url)

  val statement = conn.createStatement()
  val resultSet = statement.executeQuery("SELECT * FROM ARTISTS LIMIT 10")
  while ( resultSet.next() ) {
    val host = resultSet.getString("ArtistId")
    val user = resultSet.getString("name")
    println("host, user = " + host + ", " + user)
  }
}
