package nickson

/* differences between interfaces and abstract classes
 * 1. functions in an interface are Never final.. They can be final in an Abstract class
 * When we override those functions, we can still use default body using 'super'
 * 2. Interfaces can have properties
 * properties in Kotlin represents an abstraction of getter (val) or getter and setter (var)
 * */
interface Animal {
    // functions in an interface cannot be final, can always be overridden
    fun makeVoice() {
        print("<${this::class.simpleName} voice>")
    }
}

class Fox: Animal {
    override fun makeVoice() {
        super.makeVoice()
        print(" (I prefer to stay quiet)")
    }
}

fun main() {
    val fox = Fox()
    fox.makeVoice() // <Animal voice>
}