package nickson.collections

fun main() {
    // make an array
    val array = arrayOf(1, 3, 2)

    // make an array initialized with nulls
    val nullArray: Array<String?> = arrayOfNulls(2)

    // find out the size of an array
    val size = array.size

    // reverse the order of the items in the array
    array.reverse()

    // find out if an array contains an item
    val hasOne = array.contains(1)

    // calculate the sum of array items (if they are numeric)
    val sum = array.sum()

    // calculate average
    val average = array.average() // returns a double

    // find the min or max item (works for numbers, Strings, Chars and Booleans)
    var max = array.max()
    var min = array.min()

    // sor the array in a natural order (works for numbers, Strings, Chars and Booleans)
    array.sort()

    /* Drawbacks of Arrays
     * - You can not change an array's size
     * When you create an array, the compiler infers its size from the number of items its's initialized with.
     * Its size is then fixed for ever.
     * The array won't grow, if you want to add a new item to it, and won't shrink if you want to remove an item
     *
     * - Arrays are mutable, so they can't be updated.
     * This is a problem, if your code relies on the array not changing, this may be a source of bugs.
     *
     * Use alternatives to Arrays provided by Kotlin -> Collections
     */

}