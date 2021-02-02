object BehaviourPatterns extends App {
   
  
  trait Alphabet {
    def rulesOfOperations
  }

  abstract class GoogleSubsidiary extends Alphabet {
    val children: List[Alphabet]
  }

  class Employee extends Alphabet {
    override def rulesOfOperations: Unit = ()
  }

  val adSearch = new GoogleSubsidiary {
    override val children: List[Alphabet] = List(new GoogleSubsidiary {
      override val children: List[Alphabet] = List(new Employee, new Employee, new GoogleSubsidiary {
        override val children: List[Alphabet] = List(new Employee)

        override def rulesOfOperations: Unit = ???
      })

      override def rulesOfOperations: Unit = ???
    })

    override def rulesOfOperations: Unit = ()
  }
}