//Ejercicio

// def and(b1: Boolean, b2: Boolean) = ??? //sin &&

// def or(b1: Boolean, b2: Boolean) = ??? //sin ||

//Solución

def and(b1: Boolean, b2:  => Boolean) = if (b1) b2 else false

def or(b1: Boolean, b2: => Boolean) = if (b1) true else b2
