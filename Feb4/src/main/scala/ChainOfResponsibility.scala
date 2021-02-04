object ChainOfResponsibility extends App{
  trait Event extends Enumeration {
    type EventType = Value
    val Open, Close, Ignore, NotHandled = Value
    val eventId:Int
    val eventType: EventType
  }
  
  trait EventProcessor {
    def handle: PartialFunction[Event,Event]
  }
  
  class OpenEventHandler extends EventProcessor {
    override def handle: PartialFunction[Event, Event] = new PartialFunction[Event, Event] {
      override def isDefinedAt(x: Event): Boolean = if(x.eventType == x.Open)true else false

      override def apply(v1: Event): Event = {
        println("It is opened")
        v1
      }
    }
  }

  class CloseEventHandler extends EventProcessor {
    override def handle: PartialFunction[Event, Event] = new PartialFunction[Event, Event] {
      override def isDefinedAt(x: Event): Boolean = if(x.eventType == x.Close)true else false

      override def apply(v1: Event): Event = {
        println("It is closed")
        v1
      }
    }
  }

  class IgnoreEventHandler extends EventProcessor {
    override def handle: PartialFunction[Event, Event] = new PartialFunction[Event, Event] {
      override def isDefinedAt(x: Event): Boolean = if(x.eventType == x.Ignore)true else false

      override def apply(v1: Event): Event = {
        println("It is ignored")
        v1
      }
    }
  }
  
  val event = new Event {
    override val eventId: Int = 1
    override val eventType: EventType = NotHandled
  }
  
  val openHandler = (new OpenEventHandler).handle
  val closeHandler = (new CloseEventHandler).handle
  val ignoreHandler = (new IgnoreEventHandler).handle
  val chain = openHandler andThen  closeHandler //orElse ignoreHandler
  chain(event)
}