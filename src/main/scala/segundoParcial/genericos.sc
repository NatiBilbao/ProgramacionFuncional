def s2(x : Int) = x+2
def s3(x : Int) = x+3
def s5(x : Int) = x+5

//Los genericos son con corchetes
abstract class List[+T]{
  def isEmpty : Boolean
  def head : T
  def tail : List[T]
  def get(x : Int) : T
  def prepend[S >: T](x: S) : List[S]
}

//Clase generica
class Cons[+T](val head : T, val tail : List[T]) extends List[T]{
  override def isEmpty: Boolean = false
  override def get(x : Int) : T = if(x == 0) head else tail get x - 1
  override def prepend[S >: T](x: S): List[S] = new Cons(this)
}

//Lista vacia = Nil
object Nil extends List[Nothing]{
  override def isEmpty: Boolean = true
  override def head = throw new NoSuchElementException("Nil.head")
  override def tail = throw new NoSuchElementException("Nil.tail")
  override def get(x: Int): Nothing = throw new NoSuchElementException("Nil.get")
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

abstract class Function1[-P, +R]{
  def apply(p : P) : R
}

class Medico

class Cirujano extends Medico

def f(p : Cirujano) : Perro = ???

def primerOrden(func : Medico => Perro) = ???

//Cirujano => Perro <: Medico => Perro? No!

def g(p : Medico) : Chihuahua = ???

def primerOrden2(func : Medico => Perro) = ???

//Medico => Chihuahua <: Medico => Perro? Si

def h(n: Medico) : Perro = ???

def primerOrden3(func : Cirujano => Chihuahua) = ???

//Medico => Perro <: Cirujano => Chihuahua? No