package nickson

/* Notes on Kotlin Interfaces
 * - Interfaces can contain declarations of abstract methods as well as method implementations
 * - Differ from abstract classes in that interfaces can not store state
 * - Can have properties that need to be abstract or to provide accessor implementations
 * */

interface InterfaceOne {
    fun foo() {
        // optional body.
        // we have a body here to demonstrate that this is not an abstract method
        // If you do not have a body, you MUST override this method
    }
    fun bar() // abstract method must be overridden.
}

class ChildOne : InterfaceOne {
    override fun bar() {
        println("bar")
    }
}

/* Interface properties can:
 * - be abstract
 * - can provide implementations for accessors
 * */

interface InterfaceTwo {
    val prop: Int // abstract property

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        println(prop)
    }
}

class ChildTwo : InterfaceTwo {
    override val prop: Int = 29
}



