val x = 5 //Declaramos la variable
x + 1 //Expresion, x es inmutable

def cuadrado(x : Int) = x*x//Declaramos una función

cuadrado(x)

def sumaCuadrados(x: Int, y: Int) = cuadrado(x) + cuadrado(y) //(Int, Int) => Int
sumaCuadrados(x, x+1)

def cp(x: Int, y: =>Int) = x * x //La flecha indica que Y es un pasaje por nombre

def loop : Int = loop

cp(3, loop)