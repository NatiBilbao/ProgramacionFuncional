def s2(x : Int) = x+2
def s3(x : Int) = x+3
def s5(x : Int) = x+5

//Los genericos son con corchetes
abstract class List[T]{
  def isEmpty : Boolean
  def head : T
  def tail : List[T]
}

//Clase generica
class Cons[T](val head : T, val tail : List[T]) extends List[T]{
  override def isEmpty: Boolean = false
}

//Lista vacia = Nil
class Nil[T] extends List[T]{
  override def isEmpty: Boolean = true
  override def head: T = throw new NoSuchElementException("Nil.head")
  override def tail: List[T] = throw new NoSuchElementException("Nil.tail")
}

def singleton[T](x : T) : List[T] = new Cons(x, new Nil)

singleton(3)