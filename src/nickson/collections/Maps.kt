package nickson.collections

import nickson.Recipe

/* Map: you give it a key, and the 'Map' gives you back the value associated with that key
 * - Each entry in a 'Map' is actually two objects, 'key', 'value'
 * - A map is immutable, you can't add/remove key/value pairs or update the value against a specific key
 *
 * MutableMap:
 * - is a subtype of 'Map'
 * - you can call the same functions on a MutableMap that you can on a 'Map'
 * - has add, remove and update key/value pairs
 */

fun printRecipeMap(recipe: Map<String, Recipe>){
    println("\n---------------------------------------------------")
    for ((key, value) in recipe) {
        println("Key: $key, value: $value")
    }
    println("\n---------------------------------------------------")
}

fun main() {
    val r1 = Recipe("Chicken Soup")
    val r2 = Recipe("Quinoa Salad")
    val r3 = Recipe("Thai Curry")

    val recipeMap = mapOf("r1" to r1, "r2" to r2, "r3" to r3)
    printRecipeMap(recipeMap)

    println("recipeMap.containsKey(\"r1\") ${recipeMap.containsKey("r1")}")

    println("\n---------------------------------------------------")
    val recipeToCheck = Recipe("Thai Curry")
    println("recipeMap.containsValue($recipeToCheck) ${recipeMap.containsValue(recipeToCheck)}")

    println("\n---------------------------------------------------")
    if (recipeMap.containsKey("r1")) {
        println("recipeMap.getValue(\"r1\") ${recipeMap.getValue("r1")}")
    }
    println("\n---------------------------------------------------")

    val mRecipeMap = mutableMapOf("one" to r1, "two" to r2)
    printRecipeMap(mRecipeMap)

    println("mRecipeMap[\"three\"] = $r3")
    mRecipeMap["three"] = r3
    printRecipeMap(mRecipeMap)

    /* if MutableMap already contains the specified key, the value for that key is replaced */
}