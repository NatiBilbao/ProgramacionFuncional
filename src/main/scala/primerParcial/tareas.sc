import scala.annotation.tailrec

// Realizar un código para los números de fibonacci uno con tailrec y otro con tailrecmain
// def fiboTR(n:Int, acc1: Int, acc2:Int):Int = ???
// def fiboTRmain(n:Int ) : Int = ???

@tailrec
def fiboTR(n: Int, acc1: Int, acc2: Int): Int = if (n == 0) acc1 else fiboTR(n - 1, acc2, acc1 + acc2)

def fiboTRmain(n: Int): Int = {
  def fiboTR(n: Int, acc1: Int, acc2: Int): Int = {
    if (n == 0) acc1
    else fiboTR(n - 1, acc2, acc1 + acc2)
  }
  fiboTR(n, 0, 1)
}

//Correción tarea
def fiboTR(n:Int, i:Int, actual:Int, anterior:Int):Int = if(i == n) actual else fiboTR(n, i+1, actual+anterior)

def fiboTRmain(n: Int) : Int = fiboTR(n, 0, actual = 1, anterior = 0)

//Tarea sumFact(8,3) definir con sumF y sumInt(3,5) definir en funcion de sumF
def sumF(a: Int, b: Int, f : Int => Int): Int = {
  def inner(i : Int, acc : Int) : Int = if (i > b) acc else inner(i + 1, acc + f(i))
  inner(a, 0)
}

def sumFact(a: Int, b: Int): Int = {
  def factorial(n: Int): Int = if (n <= 0) 1 else n * factorial(n - 1)

  def inner(i: Int, acc: Int): Int = {
    if (i > b) acc
    else inner(i + 1, acc + factorial(i))
  }

  sumF(a, b, inner)
}

val result = sumFact(8, 3)
println(result)

def sumInt(a: Int, b: Int): Int = {
  def identity(x: Int): Int = x

  def inner(i: Int, acc: Int): Int = {
    if (i > b) acc
    else inner(i + 1, acc + identity(i))
  }

  sumF(a, b, inner)
}

val result = sumInt(3, 5)
println(result)

//forall: todos los resultados de f para todos los valores entre min y max cumple el predicado p

def forall(p: Int => Boolean, min: Int, max: Int)(f: Int => Int): Boolean = (min to max).forall(value => p(f(value)))

val minValue = 1
val maxValue = 10

val square = (x: Int) => x*x //Función f: elevar al cuadrado

val isGreaterThanTen = (x: Int) => x > 10 //Predicado: valor es mayor que 10

forall(isGreaterThanTen, minValue, maxValue)(square)

//exists: al menos un resultado de f entre los valores entre min y max cumple el predicador p

def exists(p: Int => Boolean, min: Int, max: Int)(f: Int => Int): Boolean = (min to max).exists(p compose f)

val minValue = 1
val maxValue = 20

val square = (x: Int) => x * x // Función f: elevar al cuadrado

val isGreaterThanFifty = (x: Int) => x > 50 // Predicado: valor es mayor que 50

exists(isGreaterThanFifty, minValue, maxValue)(square)

//Solución

//Forall
def forall(p: Int => Boolean, min: Int, max: Int)(f: Int => Int): Boolean = {
  @tailrec
  //def inner(i : Int) : Boolean = if(i > max) true else if (p(f(i))) inner(i + 1) else false //Forma larga
  //def inner(i : Int) : Boolean = (i > max) || (if(p(i))) inner(i + 1) else false //Forma semi corta
  def inner(i : Int) : Boolean = (i > max) || p(f(i)) && inner(i + 1) //Forma corta
  inner(min)
}
//Exists

def exists(p: Int => Boolean, min: Int, max: Int)(f: Int => Int) : Boolean = !forall(!p(_), min, max)(f)

