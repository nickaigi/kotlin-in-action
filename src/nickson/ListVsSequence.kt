package nickson

/**
 * Remember: extensions on collections in most cases return new collections
 * i.e.
 *      filter, map, any, find, groupBy
 *
 * To avoid this, one can make use of sequences, that make use of lazy computation
 */
fun main() {
    val list = listOf(1, 2, -3)
    val maxOddSquare = list
        .map { it * it }
        .filter { it.rem(2) == 1 }
        .max()

    println("maxOddSqare: $maxOddSquare")

    // To convert from a list to a sequence, use "asSequence"
    val list2 = listOf(1, 2, -3)
    val maxOddSquare2 = list
        .asSequence()
        .map { it * it }
        .filter { it.rem(2) == 1 }
        .max()
}