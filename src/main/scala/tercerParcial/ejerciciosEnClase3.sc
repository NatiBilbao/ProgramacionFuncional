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

//Ejercicio 4

def myFilter[T](l : List[T], p : T => Boolean) : List[T] = {
  def inner(l1 : List[T], acc : List[T]) : List[T] = l1 match {
    case Nil => acc.reverse
    case h :: t => inner(t, if(p(h)) h :: acc else acc)
  }

  inner(l, Nil)
}

def l8 = l5 filterNot((_ : Int) % 2 == 0)

//Ejercicio 5

def myFilterNot[T](l : List[T], p : T => Boolean) = myFilter(l, !p(_))

//Ejercicio 6

//No tailrecursive
def unicos[T](l : List[T]) : List[T] = l match {
  case Nil => Nil
  case h :: t => h :: unicos(t filter(_ != h))
}

unicos(List[1,1,2,3,4,4,1,2,3,4,2,1]) //List(1,2,3,4)

//Tailrecursive
def unicos[T](l : List[T]) : List[T] = {
  def inner(l1 : List[T], acc : List[T]) : List[T] = l1 match {
    case Nil => Nil
    case h :: t => inner(t filter(_ != h), h :: acc)
  }

  inner(l, Nil)
}

unicos(List[1,1,2,3,4,4,1,2,3,4,2,1]) //List(1,2,3,4)

def conteo[T](l : List[T]) : List[(T,Int)] = {
  def inner(l1 : List[T], acc : List[(T,Int)]) : List[(T,Int)] = l1 match {
    case Nil => acc.reverse
    case h :: t => {
      val(a,b) = l partition(_ == h)
      inner(b,(h,a.length) :: acc)
    }
  }

  inner(l, Nil)
}

conteo(List(1,1,2,3,4,4,1,2,3,4,2,1)) //List((1,4), (2,3), (3,2), (4,3))

