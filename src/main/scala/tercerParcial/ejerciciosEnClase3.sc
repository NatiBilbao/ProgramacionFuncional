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

//Ejercicio
 def addEnd[T](e : List[T]) : List[T] = l match {
   case Nil => List(e)
   case h :: t => h :: addEnd(e, t)
 }