package nickson.operator_overloading
/*
 * Implement 'equals2' without using '==' so that it was equivalent to 'equals1'.
 * You can call 'equals()' directly and use the reference equality operator '==='.
 */

data class Value(val s: String)

fun equals1(v1: Value?, v2: Value?): Boolean {
    return v1 == v2
}

//  use safe access ---- ?
// Elvis operator: if LHS is not null, return it else (if its null) return RHS
fun equals2(v1: Value?, v2: Value?): Boolean =
    v1?.equals(v2) ?: (v2 === null)

fun main() {
    equals1(Value("abc"), Value("abc")) eq true
    equals1(Value("abc"), null) eq false
    equals1(null, Value("abc")) eq false
    equals1(null, null) eq true

    equals2(Value("abc"), Value("abc")) eq true
    equals2(Value("abc"), null) eq false
    equals2(null, Value("abc")) eq false
    equals2(null, null) eq true
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}