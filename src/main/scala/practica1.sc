//Ejercicio 1

def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
println(pascal(0, 2))
println(pascal(1, 2))
println(pascal(1, 3))

//Solucion
def pascal(c:Int, r:Int) : Int = if(c==0 || c == r) 1 else pascal(c, r-1) + pascal(c-1, r-1)

//Ejercicio 2

def balance(chars: List[Char]): Boolean = {
  def isBalanced(chars: List[Char], count: Int): Boolean = {
    if (chars.isEmpty) count == 0
    else if (count < 0) false
    else if (chars.head == '(') isBalanced(chars.tail, count + 1)
    else if (chars.head == ')') isBalanced(chars.tail, count - 1)
    else isBalanced(chars.tail, count)
  }

  isBalanced(chars, 0)
}

// Ejercicio 3

def countChange(dinero: Int, monedas: List[Int]): Int = {
  if (dinero == 0) 1
  else if (dinero < 0 || monedas.isEmpty) 0
  else countChange(dinero - monedas.head, monedas) + countChange(dinero, monedas.tail)
}

val denominaciones = List(1, 2) // Lista de denominaciones de monedas
val cantidad = 4 // Cantidad para la que se busca el cambio

val formasDeCambio = countChange(cantidad, denominaciones)

// Ejercicio 2

def balance(chars: List[Char]): Boolean = {
  def balanceHelper(chars: List[Char], openCount: Int): Boolean = {
    if (chars.isEmpty) openCount == 0
    else if (chars.head == '(') balanceHelper(chars.tail, openCount + 1)
    else if (chars.head == ')') {
      if (openCount > 0) balanceHelper(chars.tail, openCount - 1)
      else false
    }
    else balanceHelper(chars.tail, openCount)
  }

  balanceHelper(chars, 0)
}

val example1 = "(if (¿cero? x) max (/ 1 x))".toList
val example2 = "Le dije (que no está (todavía) hecho). (Pero no me escuchó)".toList
val example3 = ":-)".toList
val example4 = "())(".toList