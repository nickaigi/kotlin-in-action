package nickson.collections

import nickson.Recipe

/* Map: you give it a key, and the 'Map' gives you back the value associated with that key
 * - Each entry in a 'Map' is actually two objects, 'key', 'value'
 * - A map is immutable, you can't add/remove key/value pairs or update the value against a specific key
 *
 * MutableMap:
 */

fun main() {
    val r1 = Recipe("Chicken Soup")
    val r2 = Recipe("Quinoa Salad")
    val r3 = Recipe("Thai Curry")

    val recipeMap = mapOf("r1" to r1, "r2" to r2, "r3" to r3)

    println("\n---------------------------------------------------")
    for ((key, value) in recipeMap) {
        println("Key is $key, value is $value")
    }
    println("\n---------------------------------------------------")
    println("recipeMap.containsKey(\"r1\") ${recipeMap.containsKey("r1")}")

    println("\n---------------------------------------------------")
    val recipeToCheck = Recipe("Thai Curry")
    println("recipeMap.containsValue($recipeToCheck) ${recipeMap.containsValue(recipeToCheck)}")

    println("\n---------------------------------------------------")
    if (recipeMap.containsKey("r1")) {
        println("recipeMap.getValue(\"r1\") ${recipeMap.getValue("r1")}")
    }
    println("\n---------------------------------------------------")

    val mRecipeMap = mutableMapOf("one" to r1, "two" to r2, "three" to r3)
}