//Ejercicio 1 - Representation

// Definición del tipo de datos Conjunto
type Conjunto = Int => Boolean

// Función característica para el conjunto de enteros negativos
def enterosNegativos: Conjunto = (x: Int) => x < 0

// Función para comprobar si un conjunto contiene un elemento
def contiene(s: Conjunto, elem: Int): Boolean = s(elem)

// Ejemplos de uso
val conjuntoNegativos = enterosNegativos

println(contiene(conjuntoNegativos, -3))  // Debería imprimir: true
println(contiene(conjuntoNegativos, 2))   // Debería imprimir: false

//Ejercicio 2 - Basic Functions on Sets
type Conjunto = Int => Boolean

def singletonConjunto(elemento: Int): Conjunto = (x: Int) => x == elemento

def unión(s: Conjunto, t: Conjunto): Conjunto = (x: Int) => s(x) || t(x)

def intersect(s: Conjunto, t: Conjunto): Conjunto = (x: Int) => s(x) && t(x)

def diff(s: Conjunto, t: Conjunto): Conjunto = (x: Int) => s(x) && !t(x)

def filtro(s: Conjunto, p: Int => Boolean): Conjunto = (x: Int) => s(x) && p(x)

//Ejercicio 3 - Queries and Transformations on Sets
type Set = Int => Boolean

def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a > 1000) true
    else if (s(a) && !p(a)) false
    else iter(a + 1)
  }
  iter(-1000)
}

def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))

def map(s: Set, f: Int => Int): Set = (x: Int) => exists(s, a => f(a) == x)

val setExample: Set = x => x >= 0 && x <= 10

println(forall(setExample, x => x > 5))
println(exists(setExample, x => x > 5))
println(map(setExample, x => x * 2)(8))


