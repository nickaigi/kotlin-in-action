package nickson.sequences

fun main() {
    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList())
}