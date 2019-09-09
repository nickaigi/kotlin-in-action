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