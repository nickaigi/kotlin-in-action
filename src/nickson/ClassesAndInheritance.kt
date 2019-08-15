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

fun main() {
    var demo = InitOderDemo("Nickson")
}