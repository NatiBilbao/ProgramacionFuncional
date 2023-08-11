import scala.annotation.tailrec

val x = 5 //Declaramos la variable
x + 1 //Expresion, x es inmutable

def cuadrado(x : Int) = x*x//Declaramos una función

cuadrado(x)

def sumaCuadrados(x: Int, y: Int) = cuadrado(x) + cuadrado(y) //(Int, Int) => Int
sumaCuadrados(x, x+1)

def cp(x: Int, y: =>Int) = x * x //La flecha indica que Y es un pasaje por nombre

//def loop : Int = loop //Funcion sin parametros

val loop: Int = loop

cp(3, loop)

// val y = 2 + 2

def y = 2 + 2 //funcion sin parámetros

y+y

def abs(x: Int)= if(x > 0) x else -x

abs(-3)

def gcd(a:Int, b:Int) : Int = if(b == 0) a else gcd(b, a%b)

gcd(119,84)

 @tailrec
 def factTR(n: Int, acc : Int): Int = if(n == 0) acc else factTR(n-1, n*acc)

def factTRmain(n: Int): Int = factTR(n, acc = 1)

factTRmain(4)

//Raiz cuadrada de los numeros
def abs(a:Double) : Double = if(a<0) -a else a

def suficiente(n:Double, a:Double) = abs(n - a*a) < 0.0001 * n

def mejorar(n:Double, a:Double) = (a+n/a)/2

def sqrt(n:Double, a:Double) : Double = if(suficiente(n,0)) a else sqrt(n, mejorar(n,a))

def sqrtMain(n:Double) = sqrt(n,1)

sqrtMain(2)

// Llaves en scala

10*{
 val a = 2
 val b = 3
 def inc(a:Int) : Int = a+1
 inc(a+b)
}

def sqrt(n:Double):Double= {
 def suficiente(a:Double) = abs(n - a*a) < 0.0001 * n
 def mejorar(a:Double) = (a+n/a)/2
 def inner(a:Double) : Double = if(suficiente(a)) a else inner(mejorar(a))
 inner(1)
}

sqrt(1e50)



