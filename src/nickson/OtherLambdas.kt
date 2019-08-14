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

    /* In Kotlin, if the last parameter of a function is a function,
     * then a Lambda expression passed as the corresponding argument can be
     * placed outside the parenthesis
     * e.g.
     *      val product = items.fold(1) {acc, e -> acc * e }
     *
     * This is known as a 'trailing lambda'
     *
     * if the lambda is the only argument to the call, parentheses
     * can be omitted entirely
     * */

    /* it:
     * - It is common to have a lambda that only takes one parameter.
     * - If the compiler can infer the signature of the lambda, it is allowed
     * to not declare the only parameter and omit the arrow operator.
     * - The lone parameter will be implicitly declared under the name 'it'
     *
     *      ints.filter { it > 0 }
     *
     * - The above literal is of type '(it: Int) -> Boolean'
     * */
    val ints = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val even = ints.filter {
        val shouldFilter = it % 2 == 0
        shouldFilter
    }
    println("even numbers: $even")

    // is ideally equivalent to
    val odd = ints.filter {
        return@filter it % 2 == 1
    }
    println("odd numbers: $odd")

    /* if the lambda parameter is unused, you can place an underscore instead of its name */
    val nick = mapOf("name" to "Nick", "age" to "99")
    nick.forEach { (_, value) -> println("$value") }

    /* if you want to explicitly declare the return type when using a lambda,
     * you are better off using an anonymous function: same as a norm function, but lacks a name
     *
     * e.g. using an expression body function
     *
     *      fun(x: Int, y: Int): Int = x + y
     *
     *  OR
     *
     *      fun(x: Int, y: Int): Int {
     *          return x +y
     *      }
     *
     * using a block body function
     * */

    /* types can be omitted if they can be inferred. */
    val greaterThanZero = ints.filter(fun(item) = item > 0)
    println("greaterThanZero: $greaterThanZero")

    /* One difference between a lambda expression and an anonymous function is the behaviour of 'non-local returns'
     *  - return statement without a label always  returns from the function declared with the 'fun' keyword
     *    meaning: a return inside a lambda will return from the enclosing function
     *    whereas a return inside an anonymous function will return from the anonymous function itself.
     * */

    /* CLOSURES: a lambda expression or anonymous function (same for a local function and an object expression)
     * can access its closure: i.e. the variables declared in the outer scope
     *
     * - unlike Java, the variables captured in the closure can be modified
     * */

    var sum = 0
    ints.filter { it > 0 }.forEach { sum += it }
    println("sum: $sum")
    /* Function Literals with receiver
     *  Nick did not fully understand this concept */
    val sumThree = fun Int.(other: Int): Int = this + other
}