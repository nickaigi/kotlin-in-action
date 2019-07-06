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

fun main(args: Array<String>) {
    // do nothing
}