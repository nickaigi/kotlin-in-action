package nickson

/* Kotlin classes may have type parameters */


class Box<T>(t: T) {
    var value = t
}

/*
 * to create an instance of 'Box'
 *
 *      var box: Box<Int> = Box<Int>(1)
 * or:
 *      var box = Box(1)
 *
 * if the type can be inferred by the compiler
 */

fun main() {

    var b = Box(2)
    println(b.value)
}