package nickson

/* Classes, objects, interfaces, constructors, functions, properties and their setters can have visibility modifiers.
 * - Getters always have the same visibility as the property
 */

/* Packages
 * Functions, properties and classes, objects and interfaces can be declared on the "top-level", i.e. directly inside a
 * package:
 * - if you do not specify any visibility modifier, 'public' is used by default = visible everywhere
 * - if a declaration is marked as 'private', it will only be visible inside the file containing the declaration.
 * - if you  mark it 'internal', it is visible everywhere in the same 'module'
 * - 'protected' is not available for top-level declarations
 */

private fun myFooFun() {
    // do things
} /* visible inside VisibilityModifiers.kt */

public var bar: Int = 5 // property is visible everywhere
    private set         //setter is visible only in VisibilityModifier.kt

internal val baz = 6

/* Classes and Interfaces
 * For members declared inside a class:
 * - 'private' means visible inside this class only (including all its members);
 * - 'protected' same as private + visible in subclasses too;
 * - 'internal' any client 'inside this module' who sees the declaring class sees its 'internal' members
 * - 'public' any client who sees the declaring class sees its 'public' members.
 *
 * Note: In Kotlin, outer class does not see private members of its inner classes.
 *
 * - If you override a 'protected' members and do not specify the visibility explicitly, the overriding member will also
 * have 'protected' visibility.
 */

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5  // 'b' is protected
}

class Unrelated(outer: Outer) {
    // outer.a, outer.b are not visible
    // outer.c and outer.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}

// TODO: Constructors

fun main() {

}