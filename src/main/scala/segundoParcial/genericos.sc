def s2(x : Int) = x+2
def s3(x : Int) = x+3
def s5(x : Int) = x+5

//Los genericos son con corchetes
abstract class List[+T]{
  def isEmpty : Boolean
  def head : T
  def tail : List[T]
}

//Clase generica
class Cons[+T](val head : T, val tail : List[T]) extends List[T]{
  override def isEmpty: Boolean = false
}

//Lista vacia = Nil
object Nil extends List[Nothing]{
  override def isEmpty: Boolean = true
  override def head = throw new NoSuchElementException("Nil.head")
  override def tail = throw new NoSuchElementException("Nil.tail")
}

def singleton[T](x : T) : List[T] = new Cons(x, Nil)

singleton(3)

class Perro {
  def ladrar = println("uau uau")
}

class Chihuahua extends Perro {

}

val p : Perro = new Chihuahua

val l : List[Perro] = new Cons[Chihuahua](new Chihuahua(), new Nil)

//Todo esto funciona
//l.isEmpty
//l.head.ladrar
//l.tail.head.ladrar