package nickson.collections

/*
 * Sets: for when you need a collection that doesn't allow duplicates.
 * - A set is an ordered collection with no duplicate values.
 * - A set holds only distinct/unique values, duplicates will be ignored.
 * - Do not have a 'get', you can use '.contains' to check for cardinality
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
}