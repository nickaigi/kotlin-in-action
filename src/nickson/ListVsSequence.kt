package nickson

/**
 * Remember: extensions on collections in most cases return new collections
 * i.e.
 *      filter, map, any, find, groupBy
 *
 * To avoid this, one can make use of sequences, that make use of lazy computation
 */

fun m(i: Int): Int {
    print("m$i ")
    return i
}

fun f(i: Int): Boolean {
    print("f$i ")
    return i.rem(2) == 0
}

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

    // .find returns the first element matching the given predicate or null ir no such element was found
    val list3 = listOf(1, 2, 3, 4)
        .map { it * it }
        .find { it > 3 }

    val list4 = listOf(1, 2, 3, 4)
    // what is printed?
    list4.map(::m).filter(::f) // m1 m2 m3 m4 f1 f2 f3 f4

    println("\nUsing asSequence()")
    list4.asSequence().map(::m).filter(::f).toList()

    println("\nUsing asSequence(): nothing is printed if we don't invoke a result call")
    list4.asSequence().map(::m).filter(::f)
}