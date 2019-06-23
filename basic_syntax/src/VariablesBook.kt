fun main(args: Array<String>) {
    val question =
            "The Ultimate Question of life, the Universe, and everything"
    val answer = 42

    /* notice that we omit the type declarations
     * if you don't specify the type, the compilers analyzes the initializer
     * expression and uses its type as the variable type.
     *
     * The initializer 42 has Int type, so the variable will have the same type
     */

    val yearsToCompute = 7.5e6  // 7.5 * 10^6
    // using a floating-point constant, the variable will have the type "Double"

    /* Mutable and Immutable variables
     *
     * val (from value) -- Immutable reference
     *
     * var (from variable) -- Mutable reference
     */

    // Easier string formatting: string templates

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello $name!")

    /* string templates: Kotlin allows you to refer to local variables in
     * string literals by putting the $ character in front of the variable name
     *
     * use ${} for complex expressions as well
     */
    if (args.size > 0) {
        println("Hellow again ${args[0]}!")
    }

    /* you can nest double quotes within double quotes, as long as they are
     * within an expression
     */
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
}