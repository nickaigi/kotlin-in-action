import java.lang.IllegalArgumentException

/* if (condition) {
*       throw IllegalArgumentException(
*           "Failed test")
* }
*
* */

fun exampleOne(percentage: Int) {
    if (percentage !in 0..100) {
        throw IllegalArgumentException("A percentage value must be between 0 andd 100: $percentage")
    } else {
        println("Allowed: $percentage")
    }
}
fun main(args: Array<String>) {
    println(exampleOne(30))
}