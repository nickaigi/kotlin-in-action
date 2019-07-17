package ch03

/* working with collections: varargs, infix calls, and library support
* - 'vararg' allows you to declare a function taking an arbitrary number of
*    arguments
*
* - an 'infix' notation lets you call some one-argument functions without
*   ceremony
*
* - 'Destructuring declaraitons allow you to unpack a single composite value
*    into multiple variables
* */

fun exampleOne3_4(){
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last())  //  fourteenth

    val numbers: Collection<Int> = setOf(1, 14, 2)
    println(numbers.max())  // 14
}

fun main (args: Array<String>) {
    /* do the things */
    exampleOne3_4()
}