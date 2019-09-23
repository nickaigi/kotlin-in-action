package nickson.collections

import nickson.Recipe

/* Map: you give it a key, and the 'Map' gives you back the value associated with that key
 * - Each entry in a 'Map' is actually two objects, 'key', 'value'
 */

fun main() {
    val r1 = Recipe("Chicken Soup")
    val r2 = Recipe("Quinoa Salad")
    val r3 = Recipe("Thai Curry")

    val recipeMap = mapOf("r1" to r1, "r2" to r2, "r3" to r3)

    for ((key, value) in recipeMap) {
        println("Key is $key, value is $value")
    }
}