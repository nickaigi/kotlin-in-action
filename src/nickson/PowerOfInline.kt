package nickson

fun myRun(f:()-> Unit) = f()

fun main() {
    val name = "Kotlin"
    myRun { println("Hi, $name!") }
}