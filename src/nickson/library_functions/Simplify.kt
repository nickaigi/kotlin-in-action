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
}