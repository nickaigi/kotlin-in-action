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
    with(sb2) {
        appendln("Alphabet2: ")
        for (c in 'a'..'z') {
            append(c)
        }
        println(toString())
    }
}