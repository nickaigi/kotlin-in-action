package nickson

/* Lambdas can be
 * a. passed as an argument to a method
 * b. returned from a method
 * c. treated like a normal kotlin object
 *
 * Definition
 *
 * val lambdaName: Type = { argList -> codeBody }
 *
 * - argList can be omitted if defining at most one arg
 * - we don't always need a variable, since the lambda can be an arg to a method
 * - the lambda type is the type of the last command within the lambda
 * */

fun main() {
    val square = { number: Int -> number * number }
    val nine = square(3)
    println("Square of 3 is $nine")

    val magnitude100String = { input: Int ->
        val magnitude = input * 100
        magnitude.toString()
    }
    println(magnitude100String(5))

    /* If Kotlin can't infer our types, you must declare the type
     *
     * input -> output
     *
     * If the code returns no value, we use the type Unit
     *
     * val that: Int -> Int = { three -> three }
     * val more: (String, Int) -> String = { str, int -> str + int }
     * val noReturn: Int -> Unit = { num -> println(num) }  
     * */

    /* the final expression in a Lambda is the value that will be returned
     * after a Lambda is returned
     */

    val calculateGrade = { grade: Int ->
        when (grade) {
            in 0..40 -> "Fail"
            in 41..70 -> "Pass"
            in 71..100 -> "Distinction"
            else -> "Fail"
        }
    }
    println("You earned a ${calculateGrade(79)}")

    /* it
     * Shorthand for a single arg passed to a Lambda
     * 'it' represents a lone arg that we pass to the Lambda
     * */

    val myArray = arrayOf(1, 2, 3, 4, 5, 6)
    /* longhand */
    myArray.forEach { item -> println(item * 4) }

    /* shorthand */
    myArray.forEach { println(it * 4) }
}