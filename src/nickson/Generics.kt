package nickson

/* Kotlin classes may have type parameters */


class Box<T>(t: T) {
    var value = t
}

fun main() {
    var b: Box<Int> = Box(2)
    println(b.value)
}