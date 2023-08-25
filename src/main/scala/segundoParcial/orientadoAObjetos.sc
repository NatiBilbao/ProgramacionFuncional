import scala.annotation.tailrec

class Fraction(x : Int, y : Int){
  require(y > 0, "Denominator must be positive") //función pre definida
  def this(x : Int) = this(x,1)


  @tailrec
  private def gcd(a : Int, b : Int): Int = if(b == a) a else gcd(b, a%b)

  //def num = x
  //def denom = y

  val num = x / gcd(x,y)
  val denom = y / gcd(x,y)

  override def toString = num + "/" + denom

  //métodos
  //def add(o : Fraction) = new Fraction(num*o.denom + o.num*denom, denom*o.denom)

  def +(o : Fraction) = new Fraction(num*o.denom + o.num*denom, denom*o.denom)

  def unary_- = new Fraction(-num, denom) //Solo para: -, +, !, ~

  def -(o : Fraction) = this + -o

  def *(o : Fraction) = new Fraction(num*o.num, denom*o.denom)

  def unary_~ = new Fraction(denom, num)

  def /(o : Fraction) = this * ~o

  def >(o : Fraction) = num*o.denom > denom*o.num

  def ==(o : Fraction) = num == o.num && denom == o.denom


}

//new Fraction(2,3) //Esto es un objeto

implicit def intoFraction(x : Int) = new Fraction(x)//"implicit "modifica una función

val a = new Fraction(2,3)
val b = new Fraction(5,3)

//a.add(b)

a + b + new Fraction(1,1)
a.+(b).+(new Fraction(1,1))
1.+(2)

-a
a == b

a + b + new Fraction(3)
a.+(b).+(new Fraction(1))

"2" + 2

2 + 2.5

//Prioridades al empezar una función

//otros
// * / %
//+ -
//:
//= !
//< >
//&
//^
//|
//letras