/* defining variables in kotlin */

// top-level variables
val PI = 3.104
var topX = 0

fun incrementX() {
    topX += 1
}

// using conditional expressions
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// using if as an expression
fun maxOfEx(a: Int, b: Int) = if (a > b) a else b

fun main(args: Array<String>) {
    // read-only local variables are defined using the keyword 'val'
    val oldA: Int = 1 // immediate assignment
    val b = 3      // 'Int' type is inferred
    val c: Int     // type required when no initializer is provided
    c = 3          // defered assignment

    // variables that can be reassigned use the 'var' keyword
    var x = 5 // 'Int' type is inferred
    x += 1

    println("The value of oldA is $oldA")
    println("The value of b is $b")
    println("The value of c is $c")
    println("The value of x is $x")
    println("The value of topX is $topX")
    incrementX()
    println("After increment: $topX")

    // String templates
    var a = 1;
    // simple name in a template
    val s1 = "a is $a"

    a = 2
    // arbitrary expression in template
    val s2 = "${s1.replace("is", "was")} but now is $a"
    println("$s2")
    println("The max of $a and $b is ${maxOfEx(a, b)}")
}
