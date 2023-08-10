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
