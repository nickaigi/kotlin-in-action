package nickson

/* Kotlin distinguishes between references that can hold a null (nullable) and those that can not*/

fun main(args: Array<String>) {
    var a: String = "abc"
    //a = null  // Compilation Error

    var b: String? = "abc"
    b = null
    println(b)

    /* since variable 'a' can never be null, calling methods/properties on 'a' are considered safe
     * never to raise a NPE */

    val l1 = a.length  // good
    println(l1)

    /* trying to access the same property on 'b' would not safe
     * the compiler raises an error */

    /* We can however use a safe call. b? */

    val l2 = b?.length
    println(l2)

    /* checking for null conditions*/
    /* explicit check
     *
     * if (b != null) b.length else -1
     *
     * but IDEA introduces the 'Elvis Expression' */

    /* Elvis operator is not unique to Kotlin.
    *
    * if value on LHS is not null, use it. Else use value on RHS*/
    val l = b?.length ?: -1
    println(l)
}