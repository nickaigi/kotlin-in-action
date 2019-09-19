package nickson.collections

/*
 * Sets: for when you need a collection that doesn't allow duplicates.
 * - A set is an ordered collection with no duplicate values.
 * - A set holds only distinct/unique values, duplicates will be ignored.
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
}