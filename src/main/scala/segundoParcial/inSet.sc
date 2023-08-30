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
  override def contains(x : Int) : Boolean = (x < e) && (left contains x) || (x > e) && (right contains x) || x == e
  override def add(x : Int) : InSet = if(x < e) new NonEmpty(e, left add x, right) else if(x > e) new NonEmpty(e, left, right add x) else this
  override def union(o : Int) : InSet = left union right union o add e
  override def toString = (if(left != Empty) left + "," else "") + e + (if(right != Empty) "," + right else "")
}




