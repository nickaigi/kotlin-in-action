package nickson.sequences

import java.math.BigInteger

fun main() {
    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList())

    // to prevent integer overflow, use BigInteger
    val bigNums = generateSequence(BigInteger.ZERO) {
        it + BigInteger.ONE
    }

    // how many times will we print the phrase "Generating element"
    val numbers2 = generateSequence(3) { n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7 }
    }
    println(numbers2.first())
}