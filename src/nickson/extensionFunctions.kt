package nickson

fun main(args: Array<String>) {
    println(changeSpacesToUnderscores("this is my text"))
    println("this is my text".convertSpacesToUnderscores())
}

/* what if we wanted to replace all spaces in a string to underscores? We could use a function*/
fun changeSpacesToUnderscores(str: String): String {
    return str.replace(" ", "_")
}

/*What if we wanted that method to be part of the String class?*/
fun String.convertSpacesToUnderscores(): String {
    return this.replace(" ", "_")
}