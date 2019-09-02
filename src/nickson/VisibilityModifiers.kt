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

fun main() {

}