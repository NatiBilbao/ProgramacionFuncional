abstract class InSet {
  def contains(x : Int) : Boolean
  def add(x : Int) : InSet
}

class Empty extends InSet {
  override def contains(x: Int): Boolean = false

  override def add(x: Int): InSet = new NonEmpty(x)
}
//Tarea completar nonEmpty y arreglar el error de x
class NonEmpty(e : Int, left : InSet, right : InSet) extends InSet {

}