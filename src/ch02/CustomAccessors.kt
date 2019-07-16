package ch02

class Rectange(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

/* the property 'isSquare' doesn't need a field to store its value
 * it has a custom getter with the implementation provided. Its value is
 * computed every time the property is accessed
 *
 * Alternative syntax:
 *      get() = height == width
 */

fun main(args: Array<String>) {
    val rectangle = Rectange(41, 43)
    println(rectangle.isSquare)
}