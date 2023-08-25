class Fraction(x : Int, y : Int){
  require(y > 0, "Denominator must be positive") //función pre definida
  def num = x
  def denom = y

  override def toString = num + "/" + denom

  //métodos
  //def add(o : Fraction) = new Fraction(num*o.denom + o.num*denom, denom*o.denom)
  def +(o : Fraction) = new Fraction(num*o.denom + o.num*denom, denom*o.denom)
}

//new Fraction(2,3) //Esto es un objeto

val a = new Fraction(2,3)
val b = new Fraction(5,3)

//a.add(b)

a + b + new Fraction(1,1)
a.+(b).+(new Fraction(1,1))
1.+(2)