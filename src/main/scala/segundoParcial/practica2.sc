//Ejercicio 1 - Representation

type Conjunto = Int => Boolean

def enterosNegativos: Conjunto = (x: Int) => x < 0

def contiene(s: Conjunto, elem: Int): Boolean = s(elem)

val conjuntoNegativos = enterosNegativos

println(contiene(conjuntoNegativos, -3))
println(contiene(conjuntoNegativos, 2))

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

//Solución

//Ejercicio 1
type Set = Int => Boolean
val a : Set = _ % 2 == 0
a(1)
def contains(s : Set, elem : Int) : Boolean = s(elem)

def singletonSet(elem : Int) = Set = _ == elem

val b = singletonSet(5)
b(4)
b(5)
b(6)

//Ejercicio 2
def union(s : Set, t : Set) : Set = (e : Int) => s(e) || t(e)

def intersect(s : Set, t : Set) : Set = (e : Int) => s(e) && t(e)

def diff(s : Set, t : Set) : Set = intersect(s, !t(_))

def filter(s : Set, p : Int => Boolean): Set = intersect(s, p)

//Ejercicio 3

def forall(s : Set, p : Int => Boolean) : Boolean = {
  def inner(i : Int): Boolean = if(i > 1000) true else
    if(s(i)) if(p(i)) inner(i + 1) else false else inner(i + 1)
    inner(-100)
}
