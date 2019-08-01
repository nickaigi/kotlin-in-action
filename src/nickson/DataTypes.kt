package nickson

/* it is allowed to omit the main parameter on the main function */

fun main() {
    /* Byte: can hold values from -128 to 127
     * Therefore, 8-bit signed two's complement number*/
    val range: Byte = 112
    println("$range")

    /* Short: can hold values from -32768 to 32767
     * 16-bit signed two's complement integer */

    val temperature: Short = -11245
    println("$temperature")

    /* Int: can hold values from -2^(31) to 2^(31) - 1
     * 32-bit signed two's complement integer
     * */

    val score: Int = 100_000 // kotlin allows the use of underscores to improve readability
    /* assigning an integer to a variable without explicitly specifying its
     * type, the variable will be of 'Int'
     */
    val anotherScore = 20
    /* Ctrl + Shift + p  to see the assigned type*/
    println("$score and $anotherScore")

    /* Long: -2^(63) to 2^(63) -1
     * 64-bit signed two's complement integer
     */
    val highScore: Long = 9999
    val distance = 10_000_000_000  // type Long
    /* you can use capital Letter L to specify that the variable is of type Long */
    val anotherDistance = 100L
    println("$distance and $highScore and $anotherDistance")

    /* Double: is a double-precision 64-bit floating point*/

    val doubleDistance = 999.5
    println("doubleDistance is $doubleDistance")

    /* Float: is a single precision 32-bit floating point */
    val floatDistance = 19.5F // use F to signal use of a float
    println("floatDistance is $floatDistance")

    /* Char: represent character
     * NB. Kotlin doesn't treat char's as numbers
     * JAVA
     *
     * char letter = 65;
     *
     * allowed. Kotlin would throw an error */
    val letter: Char = 'k'
    println("letter is $letter")

    /* Boolean: either 'true' or 'false' */
    val flag = true
    println("Boolean flag $flag")

    /* Array: the Array class has 'get' and 'set' functions.
     * One useful member function is 'size' property
     */

    /* String: String class to handle Strings */

    /* Literal Contants
     * Decimals: 123
     * Longs: 123L
     * Binary: 0b00001011
     * Doubles: 123.5 or 123.5e10
     * Floats: 123.5F
     */
}