package nickson

/* Non-literal values of function types with and without a receiver are
 * interchangeable. That is, the receiver can stand in for the first parameter
 * and vice-versa
 *
 *      (A, B) -> C
 * can be
 *      A.(B) -> C
 *
 * - Literal: value written as it's meant to be interpreted.
 *      a: String = "nick"
 * */

fun main() {
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times)}

    val twoParameters: (String, Int) -> String = repeatFun

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }
    val result = runTransformation(repeatFun)

    println("result = $result")
}