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