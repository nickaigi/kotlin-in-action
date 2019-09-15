package nickson.collections

/*
 * Kotlin has three main types of collections -- List, Set and Map
 *
 * 1. List: When sequence matters
 * - knows and cares about index position
 * - allows duplicate values
 * - you can have more than one element referencing the same object
 *
 * 2. Set: When uniqueness matters
 * - doesn't allow duplicates and doesn't care about the order in which values are held.
 * - can never have more than one element referencing the same object, or more than one element referencing two objects
 * that are considered equal.
 *
 * 3. Map: When "finding something by key" matters
 * - Key/Value pairs
 *
 *
 * Simple Lists, Sets and Maps are 'immutable'
 *
 * Kotlin provides 'MutableList', 'MutableSet' and 'MutableMap'
 *
 * MutableList:
 * - When you want a List whose values you can update.
 * - All functions available on List
 * - Has extra functions used to add/remove values or update or rearrange existing ones.
 */

fun printList(list: List<String>) {
    for (item in list) {
        println(item)
    }
}

fun main() {
    // you can be explicit with the List's type like
    // val shopping: List<String>

    val shopping = listOf("Tea", "Eggs", "Milk")

    /* its best to check the size of the List first because get() will throw 'ArrayIndexOutOfBoundsException'
     * shopping.size > 0
     *
     * but kotlin recommends using 'isNotEmpty()'
     */

    if (shopping.isNotEmpty()) {
        println("List indexing: shopping[0] = ${shopping[0]}")
    }

    /* to loop through a list */
    printList(shopping)

    if (shopping.contains("Milk")) {
        println(shopping.indexOf("Milk")) // 2
    }

    val myShopping = mutableListOf("Tea", "Eggs")
    myShopping.add("Milk")
    println("Milk: added to mutableList")
    for(item in myShopping) {
        println("item: $item")
    }

    // to add at a specific index:
    myShopping.add(1, "Coffee")

    // there are two ways to remove items from a mutableList
    if (myShopping.contains("Milk")) {
        myShopping.remove("Milk")
    }

    if (myShopping.size > 1) {
        myShopping.removeAt(1)
    }

    //remove and replace
    if (myShopping.size > 0) {
        myShopping[0] = "Bacon"
    }

    /* you can sort() and reverse() a mutableList */


}