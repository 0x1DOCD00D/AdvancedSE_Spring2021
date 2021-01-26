object Patterns2Jan26 extends App {
  case class Student(val UIN:Int, val name:String, val gpa:Float){
    require(UIN > 0)
    require(name.isEmpty != true)
  }
  val o:Any = 2;
  
  
  val akshay = Student(UIN = 1, name = "akshay", gpa = 4.0f)
  
  println(akshay)
}