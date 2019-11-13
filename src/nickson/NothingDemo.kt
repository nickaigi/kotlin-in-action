package nickson
/* Nothing
 * - not the same as Unit or void in java
 * - means "this function never returns"
 */
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}