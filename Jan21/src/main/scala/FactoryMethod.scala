object FactoryMethod {
  
  trait Car {
    def Drive():Int
  }
  
  class Tesla extends Car {
    def Drive():Int = {
      return 50;
    }
  }

  class Toyota extends Car {
    def Drive():Int = {
      return 110;
    }
  }

}
