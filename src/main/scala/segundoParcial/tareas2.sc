//Realizar las siguientes funciones:

//def subs
def subs(original: String, target: String, replacement: String): String = original.replace(target, replacement)

val inputString = "Hola, soy Natalia! Hola, Natalia!"
val targetString = "Hola"
val replacementString = "¡Hola"

  val result = subs(inputString, targetString, replacementString)
  println(result)

//def mul
def mul(a: Int, b: Int): Int = a * b

val num1 = 5
val num2 = 3
val result = mul(num1, num2)
println(s"El resultado de la multiplicación es: $result")

//def div
def div(a: Double, b: Double): Double = a / b

val dividend = 10.0
val divisor = 2.0
val result = div(dividend, divisor)
println(s"El resultado de la división es: $result")

//def <(o : Fraction) = ???
//def >=(o : Fraction) = ???
//def <=(o : Fraction) = ???

class Fraction(x : Int, y : Int){
  require(y > 0, "Denominator must be positive") //función pre definida
  def num = x
  def denom = y

  override def toString = num + "/" + denom

  def <(o : Fraction) = ???

  def >=(o : Fraction) = ???

  def <=(o : Fraction) = ???

}

