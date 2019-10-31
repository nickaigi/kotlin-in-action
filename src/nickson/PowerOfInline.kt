package nickson

fun myRun(f:()-> Unit) = f()

/* if we inline the run function */
inline fun <R> run2(block:() -> R): R = block()


fun main() {
    val name = "Kotlin"
    // under the hood, the compiler creates an anonymous class resulting in additional overhead.
    // it would have been better to just have the statement
    // println("Hi, $name!")
    // Using inline, would not result in overhead.
    myRun { println("Hi, $name!") }

    //using inline, no overhead
    run2 { println("Hi, $name!") }
}