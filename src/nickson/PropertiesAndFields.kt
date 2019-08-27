package nickson

/* Declaring properties
 * - properties in Kotlin can be mutable (var) or read-only (val)
 * - to use a property, refer to it by its name
 *
 *      var <propertyName>[: <PropertyType>] [= <property_initializer> ][<getter>][<setter>]
 *
 * - The initializer, getter and setter are optional.
 * - Property type is optional if it can be inferred from the initializer (or from the getter return type)
 * */

class Address {
    var name: String = "Nickson K"
    var street: String = "Luthuli Ave"
    var city: String = "Nairobi"
    var county: String = "Nairobi"
}

fun copyAddress(address: Address) : Address {
    var result = Address() // there is no 'new' keyword in Kt
    result.name = address.name
    result.street = address.street
    result.city = address.city
    result.county = address.county
    return result
}

class Bag {
    var color: String = "Black"
    var size: Int = 0
    var isEmpty: Boolean = true
        get() = this.size == 0
}

fun main() {
    var allByDefault: Int?
    var initialized = 1
    // read-only property declaration uses 'val' value, does not allow a setter
    val simple: Int?     // has type Int, default getter, must be initialized in constructor
    val inferredType = 1 // has type Int and a default getter

    var bag = Bag()
    println("${bag.size}, ${bag.isEmpty}")
    bag.size = 4
    println("After adding to the bag: size is ${bag.size} and isEmpty: ${bag.isEmpty}")
}