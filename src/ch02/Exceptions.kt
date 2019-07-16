import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/* if (condition) {
*       throw IllegalArgumentException(
*           "Failed test")
* }
*
* */

fun exampleOne(percentage: Int) {
    if (percentage !in 0..100) {
        throw IllegalArgumentException("A percentage value must be between 0 andd 100: $percentage")
    } else {
        println("Allowed: $percentage")
    }
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        /* possible to return null because the return type is
        * Int? can be nullable */
        return null
    }
    finally {
        reader.close()
    }
}

fun exampleTwoE() {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}

// using try as an expression
fun readNUmberExpression(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun exampleThreeE() {
    val reader = BufferedReader(StringReader("not a number"))
    readNUmberExpression(reader)
}

// returning a value in catch
fun readNumberCatch(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null  // null is used in case of an exception
    }
    println(number)
}

fun exampleFourE() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumberCatch(reader)
}

fun main(args: Array<String>) {
    //println(exampleOne(30))
    //exampleTwoE()
    //exampleThreeE()
    exampleFourE()
}