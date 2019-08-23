package nickson

import javax.swing.text.Position

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

/* An interface can derive from another interface */
interface Named {
    val name: String
}

interface PersonA: Named {
    val firstName: String
    val lastName: String
    override val name: String
        get() = "$firstName $lastName"
}


/* why do we need to repeat ourselves with 'firstName' and 'lastName' ?
 * - DRY ???
 */
data class Employee (
    //implementing 'name' is not required
    override val firstName: String,
    override val lastName: String,
    val position: Position
) : PersonA

/* Resolving overriding conflicts */
interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}