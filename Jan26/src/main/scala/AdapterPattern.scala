object AdapterPattern extends App {
  class Adaptee {
    def SomeCoreMethod(msg:String) = println(msg)
    def SomeCoreMethod(msg:Int) = println(msg)
  }
  
  trait AdapterAbstract {
    def NewMethod1: Unit
    def NewMethod2: Unit
    def NewMethod3(t:Tuple2[String, Int]): Unit
  }
  
  class Adapted extends AdapterAbstract {
    private val adapteeObject = new Adaptee

    override def NewMethod1: Unit = adapteeObject.SomeCoreMethod(2)
    override def NewMethod2: Unit = adapteeObject.SomeCoreMethod(this.getClass.getPackageName)

    override def NewMethod3(t: (String, Int)): Unit = {
      adapteeObject.SomeCoreMethod(t._1)
      adapteeObject.SomeCoreMethod(t._2)
    }
  }
  
  val oldObject = new Adaptee().SomeCoreMethod("someparam")
  
  new Adapted().NewMethod3("akshay",1)
  
}
