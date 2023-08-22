class Fraction(x : Int, y : Int){
  require(y > 0, "Denominator must be positive") //función pre definida
  def num = x
  def denom = y

  //métodos
  def add(o : Fraction) = new Fraction(num*o.denom + o.num*denom, denom*o.denom)
}

new Fraction(2,3) //Esto es un objeto