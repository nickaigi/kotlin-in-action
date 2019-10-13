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

        fun normalize(n: BigInteger, d: BigInteger): Rational {
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