package nickson

/* Kotlin makes use of the rangeTo() function, or its operator form '..' */

fun main() {

    for (i in 1..4) {
        print(i)
    }

    // reverse
    println("\nReversed using downTo function")
    for (i in 4 downTo 1) print(i)

    // using a step
    println("\nUsing a step function")
    for (i in 1..8 step 2) print(i)

    //OR
    println("\nReversed using downTo and step")
    for (i in 8 downTo 1 step 2) print(i)

    // until, excludes the upper limit
    println("\nUsing until function")
    for (i in 1 until 10) print(i)
}