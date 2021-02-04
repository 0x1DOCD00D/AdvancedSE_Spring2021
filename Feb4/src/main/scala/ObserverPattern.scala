import scala.collection.mutable.ListBuffer

object ObserverPattern extends App {
  trait Observer[T] {
    def NotifyWhenEventOccurs(event: T):Boolean
  }
  
  trait Observable[T] {
    private val observerBuffer: ListBuffer[Observer[T]] =ListBuffer()
    private val events: ListBuffer[T] = ListBuffer()
    def addObserver(observer: Observer[T]) = {
      observerBuffer += observer
    }
    
    def addEvent(event:T): Observable[T] = {
      events.+=(event)
      this
    }
  }
}
