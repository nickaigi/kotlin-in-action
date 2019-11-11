package nickson.lambda_with_receiver
/* Simplify the following code using more appropriate auxiliary functions (with, let, run, apply, also).
 */
interface X {
    var first: Int
    var second: Int
    var third: Int
}

interface Y {
    fun start()
    fun finish()
}

interface Z {
    fun init()
}

fun foo(x: X, y: Y?, z: Z) {
    /* simplification of
    x.let {
        it.first = 1
        it.second = 2
        it.third = 3
    }
    */

    with(x) {
        first = 1
        second = 2
        third = 3
    }

    /* this demonstrates an anti-pattern
    - if you use 'it', after calling 'let', you can replace this usage with a run()
    y?.let {
        with(it) {
            start()
            finish()
        }
    }
    */
    y?.run {
        start()
        finish()
    }

    /* notice that we return 'this'
    - 'apply' does exactly that.
    val result = with(z) {
        init()
        this
    }
    */

    val result = z.apply {
        init()
    }
}