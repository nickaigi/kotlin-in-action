package nickson.strings
/* Kotlin.String hides confusing methods
 * see StringExample.java
 */
fun main() {
    println("one.two.".replace(".", "*")) // one*two*
    println("one.two.".replace(".".toRegex(),"*")) // ********
}