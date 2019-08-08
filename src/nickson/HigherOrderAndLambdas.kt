package nickson

/* Kotlin functions are 'first-class' functions. They can:
 * 1. be stored in variables and data structures
 * 2. be passed as arguments to and returned from other 'higher-order' functions
 * 3. Can be operated on in any way that is possible for other non-function values
 * */

/* Higher-Order Functions: is a function that takes functions as parameters, or returns a function */

/* Function Type: used to represent the type of a function (in contrast to
 * interfaces in Java)
 * syntax:
 *      (Type, Type) -> ReturnType
 *
 * LHS - parameter types
 * RHS - the return type (use unit for empty returns)
 *
 * Examples:
 *     () -> Unit
 *     (Int) -> Int
 *     () -> () -> Unit   function type that returns another function that returns Unit
 *                        both functions take no argument
 *
 * - Function types are just syntactic sugar for an interface, but the interface
 * can not be used explicitly.
 *
 * - We can still use function types like interfaces, that is using them as 'type arguments'
 * or implementing them. See class MyFunction
 * */

fun exampleFxTypes(){
    /*
     * Function Types can be instantiated in multiple ways:
     * 1. Lambda expressions
     * */
    val filterA: (Int) -> Boolean = { it < 2}

    /* if the compiler can infer the type from the lambda expression, you can
     * omit the function type */
    val filterB = {x: Int -> x < 2 }

    /* 2. Anonymous functions: are function declarations without a name */
    val filterC = fun(x: Int): Boolean = x < 2

    /* 3. Existing function: member functions, top level functions, or existing
     * functions can be used as an instance of a function type. E.g. getting a reference
     * to the 'String.filter' function would be
     */
    val filterD = String::filter
}

class MyFunction: () -> Unit {
    override fun invoke() {
        println("I am called")
    }
}

/* Function Literal: A Literal describes syntactic sugar for representing values of some types the
 * language considers important
 * - A function literal is a special notation used to simplify how a function is defined
 * - Kotlin has 2 types of function literals
 *      1. Lambda expression
 *      2. Anonymous function
 * */

fun greetFunction() {
    println("Hello")
}

fun main() {
    val function = MyFunction()
    function()
    /* providing a function via a function reference */
    val greet = ::greetFunction
    greet()

    val anotherGreet: () -> Unit = { println("Hello anotherGreet")}
    val square: (Int) -> Int = { x -> x * x } // alternative ver { it * it }
    val producePrinter: () -> () -> Unit = { { println("I am printing") } }

    producePrinter()()

    /* using anonymous functions */

    val greetAnon: () -> Unit = fun() {
        println("Hello Anon")
    }

    val squareAnon: (Int) -> Int = fun(x) = x * x

    val producePrinterAnon: () -> () -> Unit = fun() = fun() {
        println("I am printing")
    }

    producePrinterAnon()()

    /* Remember that Kotlin can also infer Function Types*/
    val greetInferred = fun() { println("Hello Inferred")}
    val squareInferred = fun(x:Int) = x * x
    val producePrinterInferred = fun() = fun() = println("I am printing inferred")
}