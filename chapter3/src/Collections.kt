import java.lang.StringBuilder

/* we've already seen how to create a new set: 'setOf' function*/

fun exampleOne() {
    val set = hashSetOf(1, 7, 53)
    // to create a list or a map
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)   // java.util.HashSet
    println(list.javaClass)  // java.util.ArrayList
    println(map.javaClass)   // java.util.HashMap
}

fun exampleTwo() {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())  // fourteenth

    val numbers = setOf(1, 14, 2)
    println(numbers.max())  // 14
}

fun exampleThree() {
    val list = listOf(1, 2, 3)
    // simple method to print contents of a list
    println(list) // invokes toString()
}

// initial implementation of joinToString()

fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    exampleThree()
}