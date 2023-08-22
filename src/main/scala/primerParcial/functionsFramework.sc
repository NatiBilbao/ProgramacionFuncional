def f(x : Int) = 2*x
def g(x : Int) = x*x

def join(op : (Int, Int) => Int)(f : Int => Int, g : Int => Int)(x : Int) = op(f(x), g(x))
join(_+_)(f,g)(3)

def fmasg : Int => Int = join(_+_)(f,g)
def fporg : Int => Int = join(_*_)(f,g)

fmasg(3)
fporg(3)

def andres(x : Int) : Boolean =
  //if(x > 0) (x % 2 == 0) else (x % 3 == 0)
  x > 0 && x % 2 == 0 || x <= 0 && x % 3 == 0

//if(x > 0) x % 2 == 0 else true
//x <= 0 || x % 2 == 0

//Currificacion de html

def wrapper(tag : String)(content : String) = "<" + tag + ">" + content + "/>" + tag + ">"
wrapper("html")(wrapper("head")(wrapper("title")("thi is")))

def paragraph : String => String = wrapper("p")
paragraph("I love...")