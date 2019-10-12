package rational

import java.math.BigInteger

data class Rational
private constructor(val numer: BigInteger, val denom: BigInteger){
    companion object{
        fun create(n: BigInteger, d:BigInteger): Rational = normalize(n,d)

        fun normalize(n: BigInteger, d: BigInteger): Rational {
            val g = n.gcd(d)
            val sign = d.signum().toBigInteger()
            return Rational(n / g * sign, d / g * sign)
        }
    }
}