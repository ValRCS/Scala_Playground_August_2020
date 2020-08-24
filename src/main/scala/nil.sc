import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

Nil == List()
Nil == Seq()
Nil == 0
Nil == ""
Nil == Array()
Nil == ()

val now = Calendar.getInstance()
now.get(Calendar.DATE)
val yr = now.get(Calendar.YEAR)
val month = now.get(Calendar.MONTH)+1
now.get(Calendar.DATE)
val day = now.get(Calendar.DAY_OF_MONTH)
now.get(Calendar.DAY_OF_WEEK)


val df = DateTimeFormatter.ofPattern("dd/M/yyyy") //FIXME what happens when we november and December?
val today = s"$day/$month/$yr"
val dayOfWeek = LocalDate.parse(today,df).getDayOfWeek //TODO should be a way of getting day of week of date object

def getDayOfWeek(n:Int) = {
  val myDays = Seq("SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURS","FRI","SAT")
  myDays(n-1) //TODO document why -1
}

val weekDay = getDayOfWeek(now.get(Calendar.DAY_OF_WEEK))
println(s"Today is $today which is $weekDay}")
