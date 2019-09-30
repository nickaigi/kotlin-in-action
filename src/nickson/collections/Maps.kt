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
 * - has:
 *      - putAll(Map)
 *      - remove(key)
 *      - clear()
 */

fun printRecipeMap(recipe: Map<String, Recipe>){
    println("\n---------------------------------------------------")
    for ((key, value) in recipe) {
        println("Key: $key, value: $value")
    }
    println("\n---------------------------------------------------")
}

/* list.map Vs list.flatMap
 * - we demonstrate using a data class
 */

data class Data(val items: List<String>)

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

    // You can copy Maps and MutableMaps
    val recipeMapCopy = mRecipeMap.toMap()
    val recipeList = mRecipeMap.toList()
    // you can also get direct access to the key/value pairs using Map's 'entries' property
    val recipeEntries = mRecipeMap.entries

    /* demo of map vs flatMap */

    val data = listOf(Data(listOf("a", "b", "c")), Data(listOf("1", "2", "3")))

    val combined = data.flatMap { it.items }
    println(combined) // [a, b, c, 1, 2, 3]

    val combinedMap = data.map { it.items }
    println(combinedMap) // [[a, b, c], [1, 2, 3]]
}