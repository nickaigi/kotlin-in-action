package nickson.library_functions

data class Person(val name: String, var age:Int, var isPublicProfile: Boolean = false)

fun main() {
    val people = listOf(
        Person("nick",10),
        Person("son",20),
        Person("kaigi",30),
        Person("tom",40)
    )
    /* task is to find a library function that can replace this chained calls
     */

    // 1:
    people.filter { it.age < 21 }.size
    // soln 1:
    people.count { it.age < 21 }

    // 2:
    people.sortedBy { it.age }.reversed()
    // soln 2:
    people.sortedByDescending { it.age }

    // 3:
    people.map { person ->
        person.takeIf { it.isPublicProfile }?.name
    }.filterNotNull()

    // soln 3:
    people.mapNotNull { person ->
        person.takeIf { it.isPublicProfile }?.name
    }

    // 4:
    val map = mutableMapOf<Int, MutableList<Person>>()

    for (person in people) {
        if (person.age !in map) {
            map[person.age] = mutableListOf()
        }
        val group = map.getValue(person.age)
        group += person
    }

    // soln 4:
    for (person in people) {
        val group = map.getOrPut(person.age) { mutableListOf() }
        group += person
    }
    /*
     * inline fun <K, V> MutableMap<K,V>.getOrPut(
     *      key:K,
     *      defaultValue: ()-> V
     * ): V
     *
     * - returns the value for the given key. If the key is not found in the map, calls the 'defaultValue'
     *   function, puts its result in the map under the given key and returns it  */

    // Problem 5, simplify the entire code in problem 4 into a one liner
    // Soln 5:
    val mapSimple = people.groupBy { it.age }

    /* Problem 6: function that performs "groupBy" for sequences in a lazy way*/
    people
        .asSequence()
        .groupBy { it.age }
        .mapValues { (_, group) -> group.size }
}