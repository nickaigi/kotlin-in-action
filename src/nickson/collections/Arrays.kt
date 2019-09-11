package nickson.collections

fun main() {
    // make an array
    var array = arrayOf(1, 3, 2)

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

}