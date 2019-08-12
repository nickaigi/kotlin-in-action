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
    /* A value of a function type can be invoked by using its 'invoke(...) operator'
     *
     * f.invoke(x) or just f(x)
     *
     * If the value has a receiver type, the receiver object should be passed
     * as the first arg.
     * Also you can prepend it with the receiver object as if the value were an extension
     * function
     * */
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3))  // extension-like call

    /* Lambdas
     *  - always surrounded by  {}
     *  - curly braces immediately followed by optional type annotations
     *  - last expression is treated as the return value
     * */

    val sumOne = {x: Int, y: Int -> x + y}
    println("sumOne(3, 4) = ${sumOne(3, 4)}")
    // leaving out the optional type annotations
    val sumTwo: (Int, Int) -> Int = {x, y -> x + y}
    println("sumTwo(3, 4) = ${sumTwo(3, 4)}")
}