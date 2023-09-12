//Ejercicio 1

def insertionSort(l : List[Int]) : List[Int] = {
  def insert(e : Int, lo : List[Int]) : List[Int] = lo match {
    case Nil => List(e)
    case h :: _ if e <= h => e :: lo
    case h :: t =>  h :: insert(e, t)
  }

  l match {
    case Nil => l
    case h :: t => insert(h, insertionSort(t))
  }
}

insertionSort(List(3,1,4,2))

//Ejercicio 2

 def addEnd[T](e : List[T]) : List[T] = l match {
   case Nil => List(e)
   case h :: t => h :: addEnd(e, t)
 }

//Ejercicio 3
 def myMap[T, U](l : List[T], f : T => U) = {
   def inner(l1 : List[T], acc : List[U]) : List[U] = l1 match {
     case Nil => acc.reverse
     case h :: t => inner(t, f(h) :: acc)
   }

   inner(l, Nil)
 }

myMap(l5, (_:Int) % 2 == 0)