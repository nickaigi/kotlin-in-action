package nickson

/* DATA CLASSES
 *
 * - Every time we check for equality using ' == ' operator behind the scenes the ' == ' operator calls a function
 * named 'equals'
 * - Every object has an 'equals' function whose implementation determines how the ' == ' operator will behave.
 * - 'equals' is inherited class 'Any' the ultimate super class of all classes in Kotlin.
 *
 * - 'Any' defines several functions, but we are interested in:
 *      - equals(any: Any) : Boolean
 *      - hashCode(): Int
 *          - returns a hash code value for the object. Used by certain data structures to store and retrieve values
 *            more efficiently.
 *      - toString(): String
 *          - returns a string message that represents the object.
 *          - by default, this is the name of the class and some other number that we rarely care about.
 *
 * - You ca override these functions if you so wished.
 */

/* we might want 'equals' to check whether two objects are equivalent' */

class RecipeClass(val title: String, val isVegetarian: Boolean)

data class Recipe(val title: String, val isVegetarian: Boolean)

/* - you might want the == operator to evaluate to true if it's used to compare two 'Recipe' objects that have matching
 * 'title' and 'isVegetarian' properties'
 * - you may write extra code to override 'equals' to fit our use case, but the Kotlin devs came up with a better way,
 * 'data class'
 *
 * - data class: is one that lets you create objects whose main purpose is to store data.
 * - Its implementation of 'equals' checks whether two data objects hold the same property values.
 * If two objects store the same data, they can be considered equal.
 */

/* Recipe data class:
 * - hashCode() returns the same value for each object if equals is true.
 * - toString() returns a useful string that contains the value of each property that's defined in the data class
 *   constructor.
 */

/* copy function
 * - If you want to create a new copy of a data object, altering some of its properties, but leaving the rest of intact
 * you can use the copy() function.
 * - Call the function on the object you want to copy, passing in the names of any properties you wish to alter along
 * with their new values.
 */

/* TODO: componentN functions */

fun main() {
    var r1 = RecipeClass("Chicken Tikka", false)
    var r2 = RecipeClass("Chicken Tikka", false)
    println("Testing == operator on classes: ${ r1 == r2 }")

    var r3 = Recipe("Chicken Tikka", false)
    var r4 = Recipe("Chicken Tikka", false)
    println("Testing == operator on data class: ${ r3 == r4 }")

    // equal objects return the same hasCode Value
    println("r3: ${r3.hashCode()} \nr4: ${r4.hashCode()}")

    /* toString()
     * - It is redundant to call toString() inside a string template
     */
    println("r3.toString() : $r3")

    // if we had "Thai Curry" recipe
    var r5 = Recipe("Thai Curry", false)
    var r6 = r5.copy(isVegetarian = true)
    println("r6: $r6")
}