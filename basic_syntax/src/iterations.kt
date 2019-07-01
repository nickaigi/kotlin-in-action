
/* fizzbuzz: 


fun main(args: Array<String>) {
    var count = 1
    while (count < 10) {
        println("count $count")
        count += 1
    }

    do {
        println("count $count")
        count -= 1
    } while (count > 0)

    /* kotlin doesn't bring anything new to the 'while' and 'do while' loops
    * Kotlin has the 'for-each' loop
    * */

    /* to define a range in kotlin, use the .. operator
    *  start..stop
    *
    * stop is always part of the range
    * */
    val onToTen = 1..10
}