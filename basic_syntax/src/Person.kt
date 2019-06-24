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