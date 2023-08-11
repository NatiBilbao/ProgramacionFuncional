import scala.annotation.tailrec

// Realizar un codigo para los numeros de fibonacci uno con tailrec y otro con tailrecmain
// def fiboTR(n:Int, acc1: Int, acc2:Int):Int = ???
// def fiboTRmain(n:Int ) : Int = ???

@tailrec
def fiboTR(n: Int, acc1: Int, acc2: Int): Int = if (n == 0) acc1 else fiboTR(n - 1, acc2, acc1 + acc2)

def fiboTRmain(n: Int): Int = {
  def fiboTR(n: Int, acc1: Int, acc2: Int): Int = {
    if (n == 0) acc1
    else fiboTR(n - 1, acc2, acc1 + acc2)
  }
  fiboTR(n, 0, 1)
}
