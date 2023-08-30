//Ejercicio 1

//Colocar las parantesis en el lugar correcto:
//A) a + b ^ ? c ? ^ d less a ==> b | c

//Solución
//((a + b) ^ ? (c ? ^ d)) less ((a ==> b) | c)

//B) a :>< b >:< c <>: d

//Solución
//((a :>< b) >:< c) <>: d

//Ejercicio 2

//Hacer el modelo de sustitución de:
class c(x : Int){
  val a = x + 1
  def m(x : Int) = x + this.a
}

val b = new c(2)
val d = 3
b.m(d)

//Sin solucion

//Ejercicio 3
//Realizar singleton

def singleton[T](x : T) : List[T] =

