package nickson

/* Kotlin provides the ability to extend a class with new functionality without having to inherit from the class or use
 * design patterns such as Decorator.
 *
 * You can write new functions for a class from a third-party lib that you can't modify.
 * Such functions are available for calling in the usual way as if they were methods of the original class.
 * Known as 'extension functions'
 */

/* Extension functions:
 * - To delclare an extension function, we need to prefix its name with a receiver type i.e. the type being extended.
 * To add a 'swap' function to MutableList<Int>
 */

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]  // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index1] = tmp
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
}