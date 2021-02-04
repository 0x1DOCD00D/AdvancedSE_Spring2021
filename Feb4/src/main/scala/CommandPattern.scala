import scala.collection.mutable.ListBuffer

class CommandPattern[T,S] {
  val commandList : ListBuffer[T=>S] = ListBuffer()
  def add(c:T=>S) = commandList += c
  def execute(i:T) = commandList.foreach(c=>c(i))
}

class CommandPattern1 {
  val commandList : ListBuffer[Int=>Unit] = ListBuffer()
  def add(c:Int=>Unit) = commandList += c
  def execute(i:Int) = commandList.foreach(c=>c(i))
}

object CommandPattern extends App {
//  Int => Unit

  def c1(i:Int) = println(i+1)
  def c2(i:Int) = println(-i)
  
  val commandlist = new CommandPattern[Int,Unit]
  commandlist.add(c1)
  commandlist.add(c2)
  println(commandlist)
  commandlist.execute(10)
  
}
