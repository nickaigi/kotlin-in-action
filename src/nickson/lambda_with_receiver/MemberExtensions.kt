package nickson.lambda_with_receiver

class Words {
    private val list = mutableListOf<String>()

    //todo

    override fun toString() = list.toString()
}

fun main() {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}