package nickson.sequences

fun mySequence() = sequence {
    println("yield one element")
    yield(1)
    println("yield a range")
    yieldAll(3..5)
    println("yield a list")
    yieldAll(listOf(7, 9))
}


fun main() {
    val numbers = sequence {
        var x  = 0
        while (true) {
            yield(x++)
        }
    }
    //println(numbers.take(5).toList())

    println(mySequence()
        .map { it * it }
        .filter { it > 10 }
        //.take(1)) // take is not a terminal operation! Therefore, "yield ..." will not be printed at all
        .first())
}