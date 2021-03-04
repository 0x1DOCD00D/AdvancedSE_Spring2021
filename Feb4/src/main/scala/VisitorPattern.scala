import scala.collection.mutable.RedBlackTree.Tree

object VisitorPattern extends App {

  trait Visitor[T <: {def accept(t: Visitor[T]): Boolean}] {
    def visit(obj:T):Boolean
  }
  
  abstract class SomeParent {
    val id: Int = 1
    
    def accept(t: Visitor[SomeParent]): Boolean = t.visit(this)
  }

  val visitor = new Visitor[SomeParent] {
    override def visit(obj: SomeParent): Boolean = {
      println(obj.id)
      obj.id % 2 == 0
    }
  }
  
  Tree(new Child1, new Child2).map(child => child.ddd(1, "ddd", visitor))
}
