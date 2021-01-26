object BridgePattern extends App {
  trait SomeGeneralAbstract {
    def behavior: Boolean
  }
  
  trait ConcreteChild1 extends SomeGeneralAbstract {
    override def behavior: Boolean = true  
  }
  
  trait ConcreteChild2 extends SomeGeneralAbstract {
    override def behavior: Boolean = false 
  }
  
  abstract class Model {
    this: SomeGeneralAbstract =>
    def DoIt: Boolean 
  }
  
  class RefineModel1 extends Model with ConcreteChild1 {
    override def DoIt: Boolean = behavior 
  }
  
}
