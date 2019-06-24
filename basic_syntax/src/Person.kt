/* JAVA classes look like this
 * public class Person {
 *   private final String name;
 *   public Person(String name) {
 *       this.name = name;
 *   }
 *   public String getName() {
 *      return name;
 *   }
 * }
 */

/* Equivalent code in Kotlin looks like this */

class Person(val name: String)

/* classes of this type (containing only data but no code) are often called
 * Value objects
 *
 * In Kotlin, public is the default visibility.
 *
 * Java has accessor methods: getters and setters
 *
 * In Java, the combo of the field and its accessors is referred to as a "property"
 *
 * In Kt, properties are a first-class language feature, which entirely replaces
 * fields and accessor methods.
 */

class PersonMarried(
    val name: String,
    var isMarried: Boolean
)

/* JAVA
 * >> Person person = new Person("Bob", true);
 * >> System.out.println(person.getName());
 * Bob
 * >> System.out.println(person.isMarried());
 * true
 */

/*
 * Kotlin's name property is exposed to Java as a getter method called 'getName'
 * The getter and setter naming rule has an exception: if the property name
 * starts with 'is', no additional prefix for the getter is added and the
 * in setter name, 'is' is replaced with 'set'
 */

/* Kotlin
 * >> val person = Person("Bob", true)
 * >> println(person.name)
 * Bob
 * >> println(persion.isMarried)
 * true
 */