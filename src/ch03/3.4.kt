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
    /* extending the Java Collections API */
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last())  //  fourteenth

    val numbers: Collection<Int> = setOf(1, 14, 2)
    println(numbers.max())  // 14
    /* Why is it possible to do so many things with collections in Kotlin even
    * though they're instances of the Java library classes?
    * Extension Functions*/
}

fun exampleTwo3_4() {
    /* to create a list, we can pass any number of arguments to it */
    val list = listOf(2, 3, 5, 7, 11)

    /* Java has 'varargs': a feature that allows you to pass an arbitrary
    * number of values to a method by packing them in an array*/

    /*While in Java we pass the array as is, Kotlin requires you to explicitly
    * unpack the array, so that every array element becomes a separate argument
    * to the function
    *
    * we use a 'spsread operator'
    * just put a * in front of the arg*/
}

fun main (args: Array<String>) {
    /* do the things */
    val list = listOf("args: ", *args)
    println(list)
}