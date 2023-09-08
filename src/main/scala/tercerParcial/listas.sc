val l = List(1,2,3)

val li = List(List(1,2), List(3,4))

val l2 = Nil //Lista vacia

val l3 = 0 :: Nil // igual a List(0)

val l4 = 0 :: 1 :: 2 :: Nil

1.+(2)

val l5 = Nil //Lista vacia

val l6 = List() //Lista vacia las dos son lo mismo

val ll6 = List[Int]() //Lista vacia de ints

//Operaciones de listas

l4.head

l4.tail

l4.isEmpty

l4.length

l4 match {
  case Nil => -5
  case List(a,b) => a+b
  case h :: _ => h
  case x :: y :: List(a,b) :: z => 0
  case _ => 42
}
