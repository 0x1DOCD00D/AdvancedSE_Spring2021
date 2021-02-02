object ClassVsObject extends App {

  object Identity {
    val ints = List(1, 2, 3)

    def method(v: Int): List[Int] = ints.map(_ + v)
  }

  println(Identity.method(10))

  println(new {
    def method(v: Int) = v
  })
}
