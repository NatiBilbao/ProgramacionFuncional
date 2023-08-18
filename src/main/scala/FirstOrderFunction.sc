import scala.annotation.tailrec
//Primer parcial

def sumF(a: Int, b: Int, f : Int => Int): Int = {
  @tailrec
  def inner(i : Int, acc : Int) : Int = if (i > b) acc else inner(i + 1, acc + f(i))
  inner(a, 0)
}

sumF(10, 20, x => x*x)

sumF(15, 30, x => x*x)

sumF(5, 50, x => x*x)

//def sumSquares(a:Int, b:Int) = sumF(a,b,x=>x*x)

def sumSquares = sumF(_,_,x=>x*x)
sumSquares(30,60)

//Creador de saludos
def creadorDeSaludos(l : String) : String => String = (name: String) =>
  if(l == "FR")
    "Bonjuor" + name
  else if(l == "DE")
    "Hello" + name
  else if(l == "IT")
    "Ciao" + name
  else
    "Hola" + name

def saludoEnFrances = creadorDeSaludos("FR")
saludoEnFrances("Cuasimodo")
saludoEnFrances("Zinedine Zidane")
saludoEnFrances("Descartes")

def megaF2(f : Int => Int, neutro : Int, op : (Int, Int) => Int) = (a : Int, b: Int) => {
  @tailrec
  def inner(i : Int, acc: Int) : Int = if(i > b) acc else inner(i + 1, op(acc, f(i)))

  inner(a, neutro)
}

//def sumInts2 : (Int, Int) => Int = megaF2(x => x,0, _+_)

def sumInts2 = megaF2(x => x, 0, _+_)
sumInts2(3,5)

def prodInts = megaF2(x => x, 1, _ * _)
prodInts(3,7)

megaF2(x=>x, 0, _+_)(3,5)
//Asociatividad izquierda en los llamados a las funciones

//f : Int => (Int, Int) => Int //Función de f, toma un parámetro y devuelve una función y este devuelve dos parámetros
//f : Int => Int => Int => Int //Función de f, toma un parámetro y devuelve una función y este devuelve un parámetro

//g(3)(4,5) //Toma un parámetro y devuelve una funcion que toma dos parámetros que es un Int
//g : Int => (Int, Int) => Int