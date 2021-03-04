import scala.collection.mutable.ListBuffer

//model an observer that observes events - observable events - and gets notificed when these events occur
object ObserverPattern extends App {
  trait Observer[T] {//Zoom
    def NotifyWhenEventOccurs(event: T):Boolean
  }
  
  //objects of Observable are observed by all observers
  trait Observable[T] {
    //you, students or zoom listeners
    private val observerBuffer: ListBuffer[Observer[T]] =ListBuffer()
    
    private val events: ListBuffer[T] = ListBuffer()
    def addObserver(observer: Observer[T]) = {
      observerBuffer += observer
    }
    
    def addEvent(event:T): Observable[T] = {
      events.+=(event)
      this
    }
    
    def UpdateObservers = {
      observerBuffer.map(observer =>{
        events.map(event => observer.NotifyWhenEventOccurs(event))
      })
//      for {
//        observer <- observerBuffer
//        event <- events
//      } yield ((observer,event))
      
    } 
  }
  class DrMarkTheProducer {
    def IssueEvents: List[Int] = List(1,2,5)
  }
  class Linfeng(uin:Int) extends Observer[Int] {
    override def NotifyWhenEventOccurs(event: Int): Boolean = {
    println("Linfeng")  
      if(event == uin) true else false
    }
  }

  class Alex(uin:Int) extends Observer[Int] {
    override def NotifyWhenEventOccurs(event: Int): Boolean = {
      println("Alex")
      if (event == uin + 1) true else false
    }
  }

  class Shashwath(uin:Int) extends Observer[Int] {
    override def NotifyWhenEventOccurs(event: Int): Boolean = {
    println("Shashwath")  
      if(event == uin+2) true else false
    }
  }
  
  class ObservableObject extends Observable[Int]
  val zoom = new ObservableObject
  zoom.addObserver(new Linfeng(1))
  zoom.addObserver(new Alex(2))
  zoom.addObserver(new Shashwath(3))
  zoom.addEvent(1)
  zoom.addEvent(5)
  zoom.addEvent(10)
  zoom.addEvent(2)
  zoom.addEvent(3)
  zoom.addEvent(4)
  zoom.UpdateObservers
}
