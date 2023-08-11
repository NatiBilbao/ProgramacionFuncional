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

println(balance("(if (¿cero? x) max (/ 1 x))".toList))
println(balance("Le dije (que no está (todavía) hecho). (Pero no me escuchó)".toList))
println(balance(":-)".toList))
println(balance("())(".toList))