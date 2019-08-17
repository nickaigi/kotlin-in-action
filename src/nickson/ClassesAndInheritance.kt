package nickson

/* my notes on Classes and Inheritance in Kotlin
 * - A Kotlin class has one primary constructor, and one or more secondary constructors
 * - Initializer code can be placed in 'initializer blocks' which are prefixed by 'init' keyword
 * - Initializer blocks are executed in the same order as they appear in the class body
 * */

class Person(firstName: String)

class InitOderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First Initializer block that prints ${name}")
    }

    val secondProperty = "Second property ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

/* - Note that parameters of the primary constructor can be used in the initializer blocks
 * - They can also be used in property initializer declared in the class body
 * */

class Customer(name: String) {
    val customerKey = name.toUpperCase()
}

/* - The Kotlin way for declaring and initializing properties is concise*/
class Student(val firstName: String, val lastName: String, var age: Int)

fun main() {
    InitOderDemo("Nickson")
    /*
    First property: Nickson
    First Initializer block that prints Nickson
    Second property 7
    Second initializer block that prints 7
    */
    var myStudent = Student("Nick", "Son", 99)
    println("Student name is ${myStudent.firstName} ${myStudent.lastName}")
}