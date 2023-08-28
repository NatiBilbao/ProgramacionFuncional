abstract class InSet {
  def contains(x : Int) : Boolean
  def add(x : Int) : InSet
}

class Empty extends InSet {

}

class NonEmpty extends InSet {

}