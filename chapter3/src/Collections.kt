import java.lang.StringBuilder

/* we've already seen how to create a new set: 'setOf' function*/

fun exampleOne() {
    val set = hashSetOf(1, 7, 53)
    // to create a list or a map
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)   // java.util.HashSet
    println(list.javaClass)  // java.util.ArrayList
    println(map.javaClass)   // java.util.HashMap
}

fun exampleTwo() {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())  // fourteenth

    val numbers = setOf(1, 14, 2)
    println(numbers.max())  // 14
}

fun exampleThree() {
    val list = listOf(1, 2, 3)
    // simple method to print contents of a list
    println(list) // invokes toString()
}

/* initial implementation of joinToString()
* The function is generic: it works on collections that contain elements of
* any type
* */

fun <T> joinToStringA(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun exampleFour() {
    val list = listOf(1, 2, 3)
    println(joinToStringA(list, "; ", "(", ")"))
}

/* using default parameter values
* Remember: Java doesn't have the concept of default parameters.
*
* you have to specify all the parameter values explicitly when you call
* a Kotlin function with default parameter values from Java
* */

fun <T> joinToStringB(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun exampleFive() {
    val list = listOf(1, 2, 3)
    println(joinToStringB(list, ", ", "", ""))  // 1, 2, 3
    println(joinToStringB(list))  // 1, 2, 3
    println(joinToStringB(list, ";"))  // 1; 2; 3
}

/* final version of joinToString
* utility functions as extensions
* This version is almost exactly what you'll find in the kotlin standard lib
* */

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()

}

fun exampleSix() {
    val list = listOf(1, 2, 3)
    // note how we make the call to joinToString
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))  // (1; 2; 3)
}

/* extension functions are just syntactic sugar over static method calls.
* you can therefore use a specific type as a receiver type, not only a class
*
* Example: a 'join' function that can be invoked only on collections of strings
* Calling this function with a list of objects of another type won't work*/

fun Collection<String>.join(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) = joinToString(separator, prefix, postfix)


fun exampleSeven() {
    println(listOf("one", "two", "eight").join(" ")) // one two eight
}

/* static nature of extensions also means that extension functions can't be
 * overridden in subclasses
 * */

/* Declaring a mutable extension property*/


var StringBuilder.lastChar: Char
    get () = get(length -1)  // property getter
    set(value: Char) {  // property setter
        this.setCharAt(length -1, value)
    }

fun main(args: Array<String>) {
    println("Kotlin".lastChar)
}