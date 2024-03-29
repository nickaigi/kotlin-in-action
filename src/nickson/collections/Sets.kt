package nickson.collections

/*
 * Sets: for when you need a collection that doesn't allow duplicates.
 * - A set is an ordered collection with no duplicate values.
 * - A set holds only distinct/unique values, duplicates will be ignored.
 * - Do not have a 'get', you can use '.contains' to check for cardinality
 *
 * - How does a set check for duplicates?
 *      1. The Set gets the object's hash code, and compares it with the hash code of the objects already in the set.
 *          If the Set has no matching hash codes for the new value, the Set assumes that it's not a duplicate, and adds
 *          the new value.
 *
 *      2. The Set uses the ==== operator to compare the new value against any objects it contains with the same hash
 *          code.
 *          === checks whether two references refer to the same object.
 *
 *      3. The Set uses the == operator to compare the new value against any objects it contains with matching hash
 *          codes.
 *
 * Rules for overriding hashCode and equals:
 * - If two objects are equal, they must have matching hash codes
 * - If two objects are equal, calling 'equals' on either object must return true
 *      if (a.equals(b)) then (b.equals(a))
 *
 * a.equals(b) must also mean that a.hashCode() == b.hashCode()
 *
 * But
 *
 * a.hashCode() == b.hashCode() does not have to mean that a.equals(b)
 *
 * MutableSet
 * - subtype of 'Set' with extra functions that you can use to add/remove values.
 * - defined using 'mutableSetOf'
 * - You can use
 *      - addAll(<collection>)
 *      - removeAll(<collection>)
 *      - retainAll(<collection>)
 *      - clear()
 * - You can copy a MutableSet
 *      - toSet()
 *      - toList()
 */

fun printSet(set: Collection<String>) {
    println("---------------------------------------------------\n")
    for (s in set){
        println(s)
    }
    println("---------------------------------------------------\n")
}

fun main() {
    val friendSet = setOf("Jim", "Sue", "Nick")
    printSet(friendSet)

    val duplicateFriendSet = setOf("Jim", "Sue", "Nick", "Jim")
    printSet(duplicateFriendSet)  // Jim, Sue, Nick

    /* Demo: Hash codes and equality
     * 1. Equality using the === operator
     */
    val a = "Sue"
    val b = a
    val set = setOf(a, b)

    printSet(set) // Sue

    /* Equality using the == operator
     * - If you want Set to treat two different Recipe objects (data class Recipe), as equal, or equivalent, you have
     * two options:
     *      1. Make Recipe a data class
     *      2. Override 'hashCode' and 'equals' functions it inherits from 'Any'
     *
     * Option #1 is easiest.
     */

    val mFriendSet = mutableSetOf("Jim", "Sue")
    println("Created a MutableSet: ")
    printSet(mFriendSet)
    println("added \"Nick\" to  MutableSet: ")
    mFriendSet.add("Nick")
    printSet(mFriendSet)
    mFriendSet.remove("Nick")
    println("removed \"Nick\" from  MutableSet: ")
    printSet(mFriendSet)
}