package nickson.sequences

fun main() {
    val numbers = sequence {
        var x  = 0
        while (true) {
            yield(x++)
        }
    }
    println(numbers.take(5).toList())
}