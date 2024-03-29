package nickson

/* Kotlin makes use of the rangeTo() function, or its operator form '..' */

fun main() {
    for (i in 1..4) {
        print(i)
    }

    /* reverse */
    println("\nReversed using downTo function")
    for (i in 4 downTo 1) print(i)

    /* using a step */
    println("\nUsing a step function")
    for (i in 1..8 step 2) print(i)

    /* OR */
    println("\nReversed using downTo and step")
    for (i in 8 downTo 1 step 2) print(i)

    /* until, excludes the upper limit */
    println("\nUsing until function")
    for (i in 1 until 10) print(i)

    /* can be used in an if statement to check if a value belongs in a range */
    println("\nUsed to check if a value is within a range")
    if (3 in 1..10) println("Yes")

    /* range operator can also be used with characters */
    println("Characters")
    for (ch in 'a'..'f') print(ch)

    /* example wit downTo */
    for (ch in 'f' downTo 'a') print(ch)

    /* Reversed: why would I ever need this? */
    println("\nReversed")
    /* :: creates a member reference or a class reference */
    (1..9).reversed().forEach(::print)

    /* last, first, step elements */
    println("\nIf we need the first, step or the last value of the range")
    println((1..9).first) // 1
    println((1..9 step 2).step) //2
    println((3..9).reversed().last) //3

    /* Filtering ranges */
    println("Filtering")
    val r = 1..10
    /* Lambda function */
    val f = r.filter { it -> it % 2 == 0 }  // print [2, 4, 6, 8, 10]
    println(f)
}