package nickson

import java.lang.AssertionError

/* Declaring properties
 * - properties in Kotlin can be mutable (var) or read-only (val)
 * - to use a property, refer to it by its name
 *
 *      var <propertyName>[: <PropertyType>] [= <property_initializer> ][<getter>][<setter>]
 *
 * - The initializer, getter and setter are optional.
 * - Property type is optional if it can be inferred from the initializer (or from the getter return type)
 */

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

// Let's describe a useless bag
class Bag {
    val color: String = "Black"
    val size: Int = 0
    val isEmpty: Boolean
        get() = this.size == 0
    val isSmall
        get() = this.size < 10  // inferred type is Boolean
    var setterVisibility: String = "abc"
        private set // setter is private, and has default implementation
    // var setterWithAnnotation: Any? = null
    //    @Inject set // annotate the setter with Inject
    var counter =0 // NoteL the initializer assigns the backing field directly
        set(value) {
            if (value >= 0) field  = value
        }

    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }
}

/* using a setter
 * - by convention, the parameter passed to a setter is known as 'value'
 *
 *      var stringRepresentation: String
 *          get() = this.toString()
 *          set(value) = {
 *              setDataFromString(value) // parses the string and assigns values to other properties
 *          }
 */

/* Since Kotlin 1.1 you can omit the property type if it can be inferred from the getter*/

/* If you need to change the visibility of an accessor or to annotate it, but don't need to chane the default
 * implementation, you can define the accessor without defining its body*/

/* Backing Fields:
 * - Fields cannot be declared directly in Kotlin classes.
 * - When a backing field is needed, Kotlin provides it immediately.
 * - The backing field can be referenced in the accessors using 'field' identifier.
 *
 * - The 'field' identifier can only be used in the accessors of the property
 * - A backing field will be generated for a property if it uses the default implementation of at least one of the
 * accessors, or if a custom accessor references it through the 'field' identifier.
 *
 * - There will be no backing field on the 'isEmpty' property on 'class Bag'
 */

/* Backing Properties:
 * - If you want to do something that does not fit into this "implicit backing field" scheme, you can always fall back
 * to having a backing property
 */

//TODO: Compile-Time constants
fun main() {
    var allByDefault: Int?
    var initialized = 1
    // read-only property declaration uses 'val' value, does not allow a setter
    val simple: Int?     // has type Int, default getter, must be initialized in constructor
    val inferredType = 1 // has type Int and a default getter

    var bag = Bag()
    println("Bag: ${bag.size}, ${bag.isEmpty}")
}