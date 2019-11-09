package nickson.lambda_with_receiver

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
        appendln("Alphabet2: ")
        for (c in 'a'..'z') {
            append(c)
        }
        println(this.toString()) // 'this' implicit receiver to the lambda
    }
}