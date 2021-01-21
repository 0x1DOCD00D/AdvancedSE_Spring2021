object DesignPatternsRun extends App {
  import CarFactory._
  import FactoryMethod.Car
  
  def driveCar(c:Car) = c.Drive();
  
//  driveCar(new FactoryMethod.Tesla)
  
  val carObject = CarFactory(Toyota)

  println(carObject)
  
  class X
  println(new X)
  println(new X)
  println(new X)
  
}