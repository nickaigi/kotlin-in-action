package nickson.operator_overloading

/* Demo of what I have learned
 */

class Point(var x: Int, var y: Int)

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Point.times(scale: Int): Point {
    return Point(x * scale, y * scale)
}


fun main() {

}