package nickson

data class Sloth(val name: String, val isTwoFingered: Boolean) {
    fun eat() {}
    fun sleep() {}
}

fun main() {
    val sloth: Sloth

    val slothCrew = listOf(
        Sloth("Nick", false),
        Sloth("Nate", true),
        Sloth("Dottis", false)
    )

    val slothList: List<Sloth> = listOf()
    val slothList2 = listOf<Sloth>()
}