package ch02

/* using nullable values and checking for null
* a reference must be explicitly marked as nullable when null value is possible
*/

fun parseInt(str: String): Int? {
    // we've explicitly declared that this method may return null
    return str.toIntOrNull()
}

fun main(args: Array<String>){
    var myStr = "2"
    println("${parseInt(myStr)}")
}