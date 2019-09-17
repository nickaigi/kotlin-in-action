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

fun printList(list: Collection<String>) {
    println("---------------------------------------------------\n")
    for (item in list) {
        println(item)
    }
    println("\n---------------------------------------------------\n")
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
        println("\nList indexing: shopping[0] = ${shopping[0]}")
    }

    /* to loop through a list */
    printList(shopping)

    if (shopping.contains("Milk")) {
        println(shopping.indexOf("Milk")) // 2
    }

    val myShopping = mutableListOf("Tea", "Eggs", "Donuts", "Croissants", "Sausages")
    println("created a mutable list with:")
    printList(myShopping)
    myShopping.add("Milk")
    println("\nAdded to the end of mutable list")
    printList(myShopping)

    // to add at a specific index:
    myShopping.add(1, "Coffee")
    println("Added at index 1")
    printList(myShopping)

    // there are two ways to remove items from a mutableList
    if (myShopping.contains("Milk")) {
        println("\nMutableList contains \"Milk\", so we list.remove()")
        myShopping.remove("Milk")
        printList(myShopping)
    }

    if (myShopping.size > 1) {
        println("checked: MutableList.size > 1\ntrue")
        myShopping.removeAt(1)
        println("using: list.removeAt(1)")
        printList(myShopping)
    }

    //remove and replace
    if (myShopping.size > 0) {
        println("checked: MutableList.size > 0\ntrue")
        println("MutableList[0] = \"Bacon\"")
        myShopping[0] = "Bacon"
        printList(myShopping)
    }

    /* you can sort() and reverse() a mutableList */
    println("MutableList.reverse()")
    myShopping.reverse()
    printList(myShopping)

    println("MutableList.sort()")
    myShopping.sort()
    printList(myShopping)

    println("To randomize the MutableList, use shuffle()")
    myShopping.shuffle()
    printList(myShopping)

    val toAdd = listOf("Cookies", "Cheese")
    println("Using addAll($toAdd)")
    myShopping.addAll(toAdd)
    printList(myShopping)

    val toRemove = listOf("Donuts", "Sausages")
    println("Using removeAll($toRemove)")
    myShopping.removeAll(toRemove)
    printList(myShopping)

    val toRetain = listOf("Eggs", "Bacon")
    println("Using toRetain($toRetain")
    myShopping.retainAll(toRetain)
    printList(myShopping)

    println("Using clear()")
    myShopping.clear()
    printList(myShopping)
}