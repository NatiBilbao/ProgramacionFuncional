import scala.annotation.tailrec
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
  def inner(i:Int, acc:Int):Int = if(i==0) acc else inner(i-1, i*acc)
  inner(n, 1)
}

factTR(4)



