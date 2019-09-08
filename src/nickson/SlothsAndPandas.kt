package nickson

/* adapted from https://www.youtube.com/watch?v=A7oPKEj1-Fg */


/* Since Sloths and Pandas share some attributes, we could define a super class
 * and remove some of the repetition
 */
open class Mammal(val name: String) {
    fun eat() {}
    fun sleep() {}
}

data class Sloth(val slothName: String, val isTwoFingered: Boolean) : Mammal(slothName)

data class Panda(val pandaName: String) : Mammal(pandaName)

fun feedCrew(crew: List<Mammal>) {
    crew.forEach {
        it.eat()
        println(it.name + " ate some rad leaves!")
    }
}

fun main() {
    val sloth: Sloth
    // we can declare a List like below
    val slothList: List<Sloth> = listOf()
    val slothList2 = listOf<Sloth>()

    val slothCrew = listOf(
        Sloth("Nick", false),
        Sloth("Nate", true),
        Sloth("Dottis", false)
    )

    feedCrew(slothCrew)

    val pandaCrew = listOf(
        Panda("Mutwa"),
        Panda("Kaigi"),
        Panda("Gatere")
    )
    /* if we 'feedCrew(pandaCrew)' the compiler will complain
     * 'Type mismatch: required Sloth, found Panda
     */

    feedCrew(pandaCrew)


    /* Let's add a comparator, we take the first letter of the name, turn it into a character, and then compare its
     * integer value
     */

    val squad = listOf(
        Sloth("Nick", false),
        Sloth("Zate", true),
        Sloth("Dottis", false),
        Panda("Mutwa"),
        Panda("Kaigi"),
        Panda("Gatere")
    )

    val compareByNames = Comparator {a: Mammal, b: Mammal ->
        a.name.first().toInt() - b.name.first().toInt()
    }

    /* we can sort our 'squad' with the sorted function and stick our comparator in there */

    println("__________________________________________________________________________________________________")
    squad.sortedWith(compareByNames).forEach(::println )


}