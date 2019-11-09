package nickson.lambda_with_receiver

/* how the buildString function is implemented */
inline fun buildString2(
    builderAction: StringBuilder.() -> Unit
): String {
    val stringBuilder = StringBuilder()
    stringBuilder.builderAction() // you call the lambda as an extension function
    return stringBuilder.toString()
}

fun main() {
    // an ordinary programmer would write
    val sb = StringBuilder()
    sb.appendln("Alphabet: ")
    for (c in 'a'..'z'){
        sb.append(c)
    }
    println(sb.toString())

    // a kotlin programmer should aim to write
    val sb2 = StringBuilder()
    /* with(object, lambda) is a regular function that takes the lambda as its second arg
     * - recall: if a lambda is the second arg of a function, we can move it out of the parenthesis in the function
     *   call */
    with(sb2) {
        appendln("Alphabet2: ") // also 'this.appendln()'
        for (c in 'a'..'z') {
            append(c)  // also 'this.append()'
        }
        println(toString()) // 'this.toString()' uses implicit receiver to the lambda, it can be omitted.
    }

    /* recall: we can store a lambda in a variable
     * isEven is a regular lambda
     * isOdd is a lambda with receiver. note how we define its type
     *      - you put the receiver type before the parameter list, then the '.' then the parameters as usual in the
     *        parenthesis.
     * */
    val isEven: (Int) -> Boolean = { it.rem(2) == 0 }
    val isOdd: Int.() -> Boolean = {this.rem(2) ==1 }

    isEven(2) // call to a regular lambda is a like a regular function call
    /* lambda with receiver call is like calling an extension function */
    1.isOdd()

    /* another example: buildString, using a lambda with receiver */
    val s: String = buildString {
        appendln("Alphabet3: ")
        for (c in 'a'..'z') {
            append(c)
        }
    }
    println(s)
}