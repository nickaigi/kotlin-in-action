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

/* Extensions merely make new functions callable with the dot-notation on variables of this type */
open class ShapeA

class RectangeA: ShapeA()

fun ShapeA.getName() = "Shape"

fun RectangeA.getName() = "Rectangle"

fun printClassName(s: ShapeA ) {
    println(s.getName())
}

class ExampleA {
    fun printFunctionType() {
        println("Class method")
    }
}

/* Member function wins over extension function
 * or as InteliJ says it:
 * Extension is shadowed by member
 */

fun ExampleA.printFunctionType() { println("Extension function")}

/* It is however perfectly OK for extension functions to overload member functions which have the same name
 * but a different signature
 */

fun ExampleA.printFunctionType(i: Int) { println("Extension Function") }

/* Nullable receiver
 * - Extensions can be defined with a nullable receiver type.
 * - Can be called on an object variable even if its value is null, and can check for 'this == null' inside the body
 */

fun Any?.toString() : String {
    if (this == null) return "null"
    /* after the null check, 'this' is autocast to a non-null type, so the toString() below resolves to the member
     * function of the Any class
     */
    return toString()
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    printClassName(RectangeA()) // Shape
    ExampleA().printFunctionType()  // Class method
    ExampleA().printFunctionType(1)
}