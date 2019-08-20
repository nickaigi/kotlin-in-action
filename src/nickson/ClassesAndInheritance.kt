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

/* - If the derived class has no primary constructor, then  each secondary constructor has to initialize the base type
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

class Circle() : Shape() {
    override fun draw() { /*...*/ }
}

class Rectangle : Shape() {
    override val vertexCount = 4
}

/* - Note: you can override a 'val' with a 'var' property but not vice versa
 * - This is allowed because a 'val' property declares a 'get' method and overriding it as a 'var' additionally
 * declare a 'set' method in the derived class.
 * - Note: you can use the 'override' keyword as part of the property declaration in a primary constructor
 *   e.g
 *      Interface Shape {
 *          val vertexCount: Int
 *      }
 *
 *      class Rectangle(override val vertexCount: Int = 4) : Shape
 *
 *      class Polygon: Shape {
 *          override var vertexCount: Int = 0
 *      }
 * */

/* Derived Class initialization order
 * - During the construction of a new instance of a derived class, the base class initialization is done as the first
 * step (preceded only by evaluation of the arguments for the base class constructor) and thus happens before the
 * initialization logic of the derived class is run
 * */

open class BetterBase(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also { println("Initializing size in Base: $it") }
}

class BetterDerived(
    name: String,
    val lastName: String
) : BetterBase(name.capitalize().also { println("Argument for Base: $it") }) {
    init {
        println("Initializing Derived")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it")}
}

open class BetterRectangle{
    open fun draw() {
        println("Drawing a Rectangle")
    }

    val borderColor: String get () = "black"
    }
/* Calling the superclass implementation
 * -Inside an inner class, accessing the superclass of the outer class is done with the super keyword
 * qualified with the outer class name: super@OuterClass
 * */
class FilledRectangle : BetterRectangle () {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

class AnotherFilledRectangle : BetterRectangle() {
    inner class Filler {
        fun fill() { /*...*/ }
        fun drawAndFill() {
            super@AnotherFilledRectangle.draw()
            fill()
            println("Drawn a filled rectangle with color ${super@AnotherFilledRectangle.borderColor}")
        }
    }
}

/* Overriding Rules
 * - if a class inherits many implementations of the same member from its immediate superclasses, it must override this
 * member and providee its own implementation (perhaps, using one of the inherited ones). To denote the supertype from
 * which the inherited implementation is taken, we use 'super' qualified by the supertype name in angle brackets,
 * e.g. super<Base>
 */

open class SecondLastRectangle{
    open fun draw() { println("Drawing from LastRectangle") }
}

interface Polygon {
    fun draw() { println("Drawing from Polygon") } // interface members are open by default
}

class Square() : SecondLastRectangle(), Polygon {
    // to avoid ambiguity, the compiler requires that you override draw() and provide its implementation.
    override fun draw() {
        super<SecondLastRectangle>.draw()
        super<Polygon>.draw()
    }
}

/* Abstract classes
 * - a class and some of its members may be declared 'abstract'
 * - An abstract member does not have an implementation in its class.
 * - Note that we do not need to annotate an abstract class or function with 'open' -- it goes without saying
 * - We can override a non-abstract open member with an abstract one.
 * */

open class LastPolygon {
    open fun draw() {}
}

abstract class LastRectangle : LastPolygon() {
    override abstract fun draw()
}

/* Companion objects
 * - If you need to write a function that can be called without having a class instance but needs access to the
 * internals of a class (e.g. a factory method), you can write it as a member of an object declaration inside that
 * class.
 * - You could also declare a 'companion object' inside your class, you will be able to call its members using only the
 *  class name as a qualifier */

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
    Customer("Nickson")

    println("Constructing BetterDerived(\"hello\", \"world\")")
    BetterDerived("hello", "world")

    println("\nExample of Calling SuperClass implementation")
    println("----------------------------------------------")
    FilledRectangle().draw()
    println("\nCalling SuperClass from inner class")
    println("----------------------------------------------")
    AnotherFilledRectangle().Filler().drawAndFill()
    println("\nOverriding Rules")
    println("----------------------------------------------")
    Square().draw()

}