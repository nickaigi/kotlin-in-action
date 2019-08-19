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

/* Secondary Constructor
 * - A class can also declare a secondary constructors which are prefixed with keyword "constructor"*/

class AnotherPerson {
    var children: MutableList<AnotherPerson> = mutableListOf<AnotherPerson>()

    constructor(parent: AnotherPerson) {
        parent.children.add(this)
    }
}

class Constructor {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

/* Inheritance
 * - All classes in Kotlin have a common SuperClass: Any
 * - Any has 3 methods:
 *      - equals()
 *      - hashCode()
 *      - toString()
 * */

class Example // implicitly inherits from Any

/* To declare an explicit supertype, place the type after the colon in the class header*/
open class Base(p: Int)
class Derived(p: Int) : Base(p)
/* 'open'
 * - The 'open' annotation on a class is the opposite of Java's 'final': it allows others to inherit from the class
 * - By default, all classes in Kotlin are 'final'
 * - You also need to be explicit about methods you want to make overridable, also marked with 'open'
 * */

/* - If the derived class has no primary constructor, then  each secondary constructor has to initalize the base type
 * using the 'super' keyword, or to delegate to another constructor which does that
 * - Note that in this case, different secondary constructors can call different constructors of the base type
 * e.g.
 *
 *      class MyView: View {
 *          constructor(ctx: Context): super(ctx)
 *          constructor(ctx: Context, attrs: Attributes): super(ctx, attrs)
 *      }
* */

/* Overriding Methods
 * - Kotlin requires explicitl modifies for overridable members (open) and for overrides
 *
 * Overriding properties
 * - Works like overriding methods
 * */
open class Shape{
    open fun draw(){ /*...*/ }
    fun fill(){ /*...*/ }
    // overridable property
    open val vertexCount: Int = 0
}

class Circle(): Shape() {
    override fun draw() { /*...*/ }
}

class Rectangle: Shape() {
    override val vertexCount = 4
}

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

    /* To create an instance of a class, you call the constructor as if it were a normal function */
    val customer = Customer("Nickson")
}