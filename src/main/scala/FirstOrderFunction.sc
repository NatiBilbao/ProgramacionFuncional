import scala.annotation.tailrec
//Primer parcial
@tailrec
def sumF(a: Int, b: Int, f : Int => Int): Int = {
  def inner(i : Int, acc : Int) : Int = if (i > b) acc else inner(i + 1, acc + f(i))
  inner(a, 0)
}

sumF(10, 20, x => x*x)

sumF(15, 30, x => x*x)

sumF(5, 50, x => x*x)

//def sumSquares(a:Int, b:Int) = sumF(a,b,x=>x*x)

def sumSquares = sumF(_,_,x=>x*x)
sumSquares(30,60)