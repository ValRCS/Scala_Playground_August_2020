import java.io.File

def getListOfFiles(dir: String, postFix: String = ".scala"):List[File] = {
  val d = new File(dir)
  if (d.exists && d.isDirectory) {
    d.listFiles.filter(_.isFile).filter(f => f.getName.endsWith(postFix)).toList
  } else {
    List[File]()
  }
}

println(getListOfFiles("C:\\Users\\val-p1\\Github", postFix = ".txt"))

