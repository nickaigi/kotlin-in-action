package nickson.operator_overloading

/* Demo of what I have learned
 */

data class Point(var x: Int, var y: Int) {
    override fun toString(): String {
        println("x: $x, y: $y")
        return super.toString()
    }
}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Point.times(scale: Int): Point {
    return Point(x * scale, y * scale)
}

// unary operators
operator fun Point.inc() = Point(++x,  ++y)
operator fun Point.dec() = Point(--x,  --y)

fun main() {
    val pa = Point(1, 2)
    var pb = pa * 3

    println(pb)
    println(pb - pa)
    println(pb + pa)
    println("Before increment: $pb")
    ++pb
    println("After increment: $pb")
}