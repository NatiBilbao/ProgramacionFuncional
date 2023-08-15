import scala.annotation.tailrec

//Primer parcial

// Realizar un código para los números de fibonacci uno con tailrec y otro con tailrecmain
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

//Correción tarea
def fiboTR(n:Int, i:Int, actual:Int, anterior:Int):Int = if(i == n) actual else fiboTR(n, i+1, actual+anterior)

def fiboTRmain(n: Int) : Int = fiboTR(n, 0, actual = 1, anterior = 0)

//Tarea sumFact83,5 definir con sumF y sumInt35 definir en funciion de sumF