import scala.collection.mutable.ListBuffer

object StrategyDesignPattern extends App {
  class StrategyPattern[T, S] {
    //our machinery
    var allStrategies:ListBuffer[T=>S] = ListBuffer()
    def Machinery(strategy: T=>S)(i:T): S = {
      println(i)
      strategy(i)
    }
  }
  
  trait Strategy[T,S] {
    def saveMoney(input:T):S
  }
  
  abstract class CreditCardXact
  
  class StrategyConvert2String extends Strategy[Int,String] {
    override def saveMoney(input: Int): String = (input*0.1).toString 
  }

  new StrategyPattern().Machinery((new StrategyConvert2String).saveMoney)(10)
  new StrategyPattern().Machinery((i:Int)=>(i*0.1).toString)(10)
}
