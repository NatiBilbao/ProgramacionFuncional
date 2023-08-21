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

def sumF(a: Int, b: Int, f : Int => Int): Int = {
  def inner(i : Int, acc : Int) : Int = if (i > b) acc else inner(i + 1, acc + f(i))
  inner(a, 0)
}

//Ejercicio 4

//1) Definir prodF
//prodF(2,4,f) = f(2)*f(3)*f(4)

def prodF(start: Int, end: Int, f: Int => Int): Int = if (start > end) 1 else f(start) * prodF(start + 1, end, f)

def square(x: Int): Int = x * x
val result = prodF(2, 4, square)  // Esto calculará 2*2*3*3*4*4 = 576
println(result)

//Solución
def prodF(a:Int, b:Int, f:Int=> Int) = {
  @tailrec
  def inner(i : Int, acc : Int) : Int = if(i>b) acc else inner(i+1, acc*f(i))
  inner(a, 1)
}

//2) Utilizar prodF para redefinir fact
// def fact(n:Int) = ???

def prodF(start: Int, end: Int, f: Int => Int): Int = if (start > end) 1 else f(start) * prodF(start + 1, end, f)

def fact(n: Int): Int = {
  def identity(x: Int): Int = x
  prodF(1, n, identity)
}

val result = fact(5)  // Esto calculará 5! = 5*4*3*2*1 = 120
println(result)

//Solución

def fact(n : Int) = prodF(1,n,_)

//3) Hacer una gran función que factorice sumF y prodF

def prodF(a: Int, b: Int, f: Int => Int): Int = {
  @tailrec
  def inner(i: Int, acc: Int): Int = if (i > b) acc else inner(i + 1, acc * f(i))
  inner(a, 1)
}

def fact(n: Int): Int = prodF(1, n, identity)

//Solución

def megaF(a : Int, b : Int, f : Int => Int, neutro : Int, op : (Int, Int) => Int) = {
  @tailrec
  def inner(i : Int, acc : Int) : Int = if(i > b) acc else inner(i+1, op(acc, f(i)))
  inner(a, neutro)
}

megaF(5, 7, _/2, 1, _*_) // Es igual que prodF(5,7,_/2)

//4) Hacer una función collatz que da el largo de la secuencia de collatz desde cierto número
//collatz(1) = 1
//collatz(4) = 3
//collatz(5) = 5

//def collatz(n : Int) : Int = if(n == 1) 1 else if(n % 2 == 0) 1 + collatz(n/2) else 1 + collatz(3*n+1) // no es tailrec

def collatz(n : Int) : Int = {
  @tailrec
  def inner(i: Int, acc: Int): Int =
    if (i == 1) acc + 1 else if (i % 2 == 0) inner(i / 2, acc + 1) else
      inner(3*i+1, acc+1)
  inner(n, 0)
}

//5) Utilizar la función del inciso 3 para encontrar el número la secuencia de collatz más larga en un rango
//longestCollatz(2,5) = 3

//def longestCollatz(a:Int, b:Int) = {
  //def max(x : Int, y : Int) = if(x > y) x else y
  //megaF(a,b ,collatz, 0, max)
//}

def longestCollatz(a: Int, b: Int) = megaF(a, b, collatz, 0, _ max _)

//Ejercicio 4 - functionsFramework

def f(x : Int) = 2*x
def g(x : Int) = x*x

//a) Hacer la composición de dos funciones
//def comp()
//comp(f,g)(3) //18





