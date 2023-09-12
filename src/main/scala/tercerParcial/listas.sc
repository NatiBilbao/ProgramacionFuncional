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

//Merge sort

def mergeSort(l : List[Int]) : List[Int] = {
  def merge(l1 : List[Int], l2 : List[Int], acc : List[Int]) : List[Int] = (l1, l2) match {
    case (Nil, _) => acc.reverse ::: l2
    case (_, Nil) => acc.reverse ::: l1
    case (h1 :: t1, h2 :: t2) =>
      if(h1 <= h2) merge(t1, l2, h1 :: acc) else merge(l1, t2, h2 :: acc)
  }

  if(l.length< 2) l else {
    val (left, right) = l splitAt l.length / 2
    merge(mergeSort(left), mergeSort(right), Nil)
  }
}

val l7 = l5 map((_ : Int) * 2)

def myMap[T, U](l : List[T], f : T => U) = {
  def inner(l1 : List[T], acc : List[U]) : List[U] = l1 match {
    case Nil => acc.reverse
    case h :: t => inner(t, f(h) :: acc)
  }

  inner(l, Nil)
}

myMap(l5, (_:Int) % 2 == 0)

def l5 = l5 filter ((_:Int) % 2 == 0)

def myFilter[T](l : List[T], p : T => Boolean) : List[T] = {
  def inner(l1 : List[T], acc : List[T]) : List[T] = l1 match {
    case Nil => acc.reverse
    case h :: t => inner(t, if(p(h)) h :: acc else acc)
  }

  inner(l, Nil)
}

def l9 = l5 filterNot((_ : Int) % 2 == 0)

def myFilterNot[T](l : List[T], p : T => Boolean) = myFilter(l, !p(_ : T))

val(l10, l11) = l5 partition((_:Int) % 2 == 0)



