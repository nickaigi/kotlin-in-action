package nickson

/* differences between interfaces and abstract classes
 * 1. functions in an interface are Never final.. They can be final in an Abstract class
 * */
interface Animal {
    // functions in an interface cannot be final, can always be overridden
    fun makeVoice() {
        print("<${this::class.simpleName} voice>")
    }
}

class Fox: Animal

fun main() {
    val fox = Fox()
    fox.makeVoice() // <Animal voice>
}