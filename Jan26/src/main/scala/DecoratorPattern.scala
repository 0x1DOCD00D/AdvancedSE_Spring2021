object DecoratorPattern {
  val UIN:Int = 1
  val studentName:String = "Claudio"
  
  def getStudentbyName(n:String) = ???
  
  case class StudentInfo(uin:Int, name:String)
  case class Classroom(students:List[StudentInfo])
  
  //ls, ssh, ps
  trait Command {
    val commandName:String
  }
  class LS extends Command{
    val commandName:String = "ls"
  }
  case class UnixCommand(cmd:Command)

}
