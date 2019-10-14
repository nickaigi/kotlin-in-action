package rational

import java.lang.IllegalArgumentException
import java.math.BigInteger


/* if your class implements comparable, you don't need to create the separate class Rational range
 * Belonging to range automatically works if your class implements comparable.
 */
data class Rational
private constructor(val numer: BigInteger, val denom: BigInteger): Comparable<Rational>{
    override fun compareTo(other: Rational): Int {
        return (numer * other.denom - other.numer * denom).signum()
    }

    companion object{
        fun create(n: BigInteger, d:BigInteger): Rational = normalize(n,d)

        private fun normalize(n: BigInteger, d: BigInteger): Rational {
            val g = n.gcd(d)
            val sign = d.signum().toBigInteger()
            return Rational(n / g * sign, d / g * sign)
        }
    }

    operator fun unaryMinus(): Rational = create(-numer, denom)

    operator fun plus(other: Rational) = create(
        numer * other.denom + other.numer * denom,
        denom * other.denom
    )

    operator fun minus(other: Rational): Rational = create(
        numer * other.denom - other.numer * denom,
        denom * other.denom
    )

    operator fun times(other: Rational) =
        create(numer * other.numer, denom * other.denom)

    operator fun div(other: Rational) =
        create(numer * other.denom, denom * other.numer)

}

fun String.toRational(): Rational {
    /* alternatively:
     * use:
     * fun String.toBigIntegerOrFail() =
     *      toBigIntegerOrNull() ?: throw IllegalArgumentException(message)
     */
    fun fail(): Nothing = throw IllegalArgumentException(
        "Expecting rational in the form of 'n/d' or 'n' was: $this"
    )
    if (!contains("/")) {
        val number = toBigIntegerOrNull() ?: fail()
        return Rational.create(number, BigInteger.ONE)
    }

    val (numerText, denomText) = split("/")
    val numer = numerText.toBigIntegerOrNull() ?: fail()
    val denom = denomText.toBigIntegerOrNull() ?: fail()
    return Rational.create(numer, denom)
}

infix fun BigInteger.divBy(denominator: BigInteger) =
    Rational.create(this, denominator)


infix fun Int.divBy(denominator: Int) =
    Rational.create(this.toBigInteger(), denominator.toBigInteger())

infix fun Long.divBy(denominator: Long) =
    Rational.create(this.toBigInteger(), denominator.toBigInteger())


fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}