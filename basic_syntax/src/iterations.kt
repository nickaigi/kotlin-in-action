
/* fizzbuzz:
* - if any number is divisible by 3 = Fizz
* - if any number is divisible by 5 = Buzz
* - if number is divisible by both 3 and 5 = FizzBuzz */

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun exampleOne() {
    /*  kotlin doesn't bring anything new to the 'while' and 'do while' loops
     *  Kotlin has the 'for-each' loop
     */

    var count = 1
    while (count < 10) {
        println("count $count")
        count += 1
    }

    do {
         println("count $count")
         count -= 1
    } while (count > 0)
}

fun exampleTwo() {
    /* to define a range in kotlin, use the .. operator
    *  start..stop
    *
    * stop is always part of the range
    * */
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
}

fun exampleThree() {
    /* for loop with a step */
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
}

fun exampleFour() {
    /* you can use 'until'
    * for (x in number until size)
    *
    * Key difference between 1..10 and 1 until 10 is that
    *
    *   - 1..10 includes the stop number
    *   - 1 until 10 does not include the stop number
    *
    * */
    for (i in 1 until 30) {
        print(fizzBuzz(i))
    }
}

fun main(args: Array<String>) {
    exampleFour()
}
