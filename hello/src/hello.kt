// function havint two Int parameters with Int return type
fun sum(a: Int, b: Int): Int {
    return a + b
}

//function with an expression body and inferred return type
fun sum2(a: Int, b: Int) = a + b

//function returning no meaningful value
fun sum3(a: Int, b: Int): Unit {
    println("sum3 of $a and $b is ${a + b}")
}

// Unit return type can be omitted
fun sum4(a: Int, b: Int){
    println("sum4 of $a and $b is ${a + b}")
}

fun main(args: Array<String>) {
    println("Hello, world")
    println("Sum is : ${sum(3, 4)}")
    println("sum2 is ${sum2(3, 4)}")
    sum3(3, 4)
    sum4(3, 4)
}