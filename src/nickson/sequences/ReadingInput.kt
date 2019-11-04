package nickson.sequences

fun main() {
    val input = generateSequence {
        readLine().takeIf { it != "exit" }
    }
    println(input.toList())
}