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

fun main(args: Array<String>) {
    println(Color.BLUE.rgb())
}