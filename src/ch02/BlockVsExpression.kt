/* demonstrates the difference between traditional block body functions
* expression body functions
 */

fun maxBlock(a: Int, b: Int): Int {
    return if (a > b) a else b
    /* if is an expression, not a statement
    * expression: has a value, which can be used as part of another expression
    *
    * statement: is always a top-levvel element in its enclosing block and
    * doesn't have its own value.
    *
    * In Java, all control structures are statements.
    * In Kotlin, most control structures, except for the loops
    * (for, do and do/while) are expressions
    *
    * Assignments are expressions in Java and become statements in Kotlin
     */
}

fun maxExpression(a: Int, b: Int): Int = if (a > b) a else b

/* the max function can be simplified by omitting its return type
 */

fun max(a: Int, b: Int) = if (a > b) a else b

/* Note: omitting the return type is allowed only for functions with an
 * expression body.
 * For functions with a block body that return a value, you have to specify the
 * return type and write the "return" statements explicitly.
 */

fun main(args: Array<String>) {
    println("max of 5 and 8 is ${maxBlock(5, 8)}")
    println("max of 9 and 6 is ${maxExpression(9, 6)}")
    println("${max(11, 9)} is the max of 11 and 9")
}