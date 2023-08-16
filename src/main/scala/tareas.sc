import scala.annotation.tailrec

//Primer parcial

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
