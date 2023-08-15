import scala.annotation.tailrec

//Primer parcial

//Ejercicio 1

// def and(b1: Boolean, b2: Boolean) = ??? //sin &&
// def or(b1: Boolean, b2: Boolean) = ??? //sin ||

//Solución

def and(b1: Boolean, b2:  => Boolean) = if (b1) b2 else false

def or(b1: Boolean, b2: => Boolean) = if (b1) true else b2

// Ejercicio 2

// def factorial(n: Int): Int = ???

def factorial(n: Int): Int = {
  if (n <= 1) {
    1
  } else {
    n * factorial(n - 1)
  }
}

// Solucion 2

def factorial(n: Int): Int = if(n==0) 1 else factorial(n-1)

//Modelo de sustitución de gcd(14,21) y de fact(4) fact --> abreviatura de factorial

// Ejercicio 3
//Hacer dos versiones de fibonacci tailrec y otro normal, fibo(0) = 1, fibo(1) = 1
// def fibo(n:Int):Int = ???

//Solucion
//No tailrec
def fibo(n:Int): Int = if(n<=1) 1 else fibo(n-1) + fibo(n-2)

//Raiz cuadrada de los numeros
def abs(a:Double) : Double = if(a<0) -a else a

def suficiente(n:Double, a:Double) = abs(n - a*a) < 0.0001 * n

def mejorar(n:Double, a:Double) = (a+n/a)/2

def sqrt(n:Double, a:Double) : Double = if(suficiente(n,0)) a else sqrt(n, mejorar(n,a))

def sqrtMain(n:Double) = sqrt(n,1)

// Hacer la factorial por bloques

def factTRmain(n: Int): Int = {
  def factTR(n: Int, acc: Int): Int = {
    if (n <= 1) {
      acc
    } else {
      factTR(n - 1, n * acc)
    }
  }

  factTR(n, 4)
}

// Solucion

def factTR(n:Int):Int = {
  @tailrec
  def inner(i:Int, acc:Int):Int = if (i==0) acc else inner(i-1, i*acc)
  inner(n, 1)
}

factTR(4)

//Hacer la suma de los enteros entre a y b
 def sumInts(a: Int, b: Int): Int = {
   def inner(i : Int, acc : Int) : Int = if (i > b) acc else (inner(i + 1, acc + i))

   inner(a, 0)
 }
sumInts(3,3)
sumInts(3,4)
sumInts(3,5)
sumInts(5,3)

//Hacer la función sumCubes suma de los cubos de a y b
//def sumCubes(a: Int, b: Int) : Int = ???

def cube(x : Int): Int = x*x*x
def sumCubes(a: Int, b: Int): Int = {
  def inner(i : Int, acc : Int) : Int = if (i > b) acc else inner(i + 1, acc + cube(i))
  inner(a, 0)
}

def sumFacts(a: Int, b: Int): Int = {
  def inner(i : Int, acc : Int) : Int = if (i > b) acc else inner(i + 1, acc + factTR(i))
    inner(a, 0)
}





