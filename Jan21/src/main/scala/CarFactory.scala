object CarFactory extends Enumeration {
  type AbstractCarFactory = Value
  val Chevy, Ford, Toyota, Tesla = Value
  
  trait Car
  class Chevy extends Car
  class Ford extends Car
  class Toyota extends Car
  class Tesla extends Car
  
  def apply(carType: CarFactory.AbstractCarFactory): Option[Car] ={
    carType match {
      case Chevy => Some(new Chevy)
      case Ford => Some(new Ford)
      case Toyota => Some(new Toyota)
      case Tesla => Some(new Tesla)
      case _ => None
    }
  }
}
