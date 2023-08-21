def f(x : Int) = 2*x
def g(x : Int) = x*x

def join(op : (Int, Int) => Int)(f : Int => Int, g : Int => Int)(x : Int) = op(f(x), g(x))
join(_+_)(f,g)(3)

def fmasg : Int => Int = join(_+_)(f,g)
def fporg : Int => Int = join(_*_)(f,g)

fmasg(3)
fporg(3)

//Logica de 1er orden