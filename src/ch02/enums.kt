import java.lang.Exception

/* think of the 'when' construct as a replacement for the 'switch' construct
 * in Java
 */

enum class Colors {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

/* rare case where a Kotlin declaration uses more keywords than the
 * corresponding Java: enum while in Kt: enum class
 *
 * enum is a 'soft-keyword': only has special meaning when it comes before
 * class, but it can be used as a regular name in other places
 */

/* Like in Java, enums can have properties and methods */

enum class Color(
        val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);  // semi-colon is required

    fun rgb() = (r * 256 + g) * 256 + b
}

/* using 'when' to deal with enum classes
* like 'if', 'when' is an expression that returns a value, so you can write a
* function with an expression body, returning the 'when' expressoin directly
* */

fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

/* notice that we don't have 'break' statement like in Java
* you can combine multiple values in the same branch if you separate them witj
* commas
* */

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "Warm"
    Color.GREEN -> "Neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "Cold"
}

/* if you are bored, you can always import enum constants inorder to access them
 * without a qualifier
 *
 * import enums.Color
 * import enums.Color.*
 *
 */

/* 'when' is more powerful than 'switch' in Java since 'when' allows the use of
 * any object
 */

fun mix(c1: Color, c2: Color) =
        when(setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

/*
* if no argument is supplied for the 'when' expression, the branch condition is
*  any Boolean Expression
* */
fun mixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
            (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
            (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
            else -> throw Exception("Dirty Color")
        }

fun main(args: Array<String>) {
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
    println(getWarmth(Color.ORANGE))
    println(mix(Color.BLUE, Color.YELLOW))
    println(mixOptimized(Color.BLUE, Color.YELLOW))
}