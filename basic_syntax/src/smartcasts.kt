import java.lang.IllegalArgumentException

/*
* we will write a function that evaluates simple arithmetic expressions like
* (1 + 2) + 4
*
* our example will only include one type of operation: sum of two numbers
*
* we store the expression in a tree-like structure where each node is either
* a sum(Sum) or a number (Num)
* Num - a leaf node
* Sum - node has two children
*
* we use an interface called 'Expr' and two classes 'Num' and 'Sum' to
* implement this
*
* The interface doesn't declare any methods.
* To mark a class implements an interface, use color (:) followed by interface
* name
*  */

interface Expr
class Num(val value: Int): Expr

// the arg of a Sum operation can be any Expr, either Num or another Sum
class Sum(val left: Expr, val right: Expr) : Expr

/* to store the expression (1+2) + 4
* Sum(
*     Sum(
*         Num(1), Num((2)
*     ), Num(4)
* )
* */
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

/* use 'is' to check whether a variable is of a certain type
* Java uses 'instanceof'
*
* But if you've checked that a var has a certain type and needs to access
* members of that type, you will have to add an explicit cast after the
* instanceof check
*
* In Kotlin, if you check the certain type, you don't need to cast it afterward
* you can use it as having the type you checked for. The compiler performs the
* cast for you: 'smart cast'
* */

/* refactoring the eval function into a more idiomatic Kotlin style */

/* 'if' in Kotlin differs from 'if' in Java *
 * Java has a ternary operator
 *
 *  a > b ? a: b
 *
 * Kotlin has no ternary operator, because unlike Java, the 'if' expression
 * returns a value: thus the expression body syntax
 *
 */

fun evalIf(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            evalIf(e.right) + evalIf(e.left)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }
/* *curly braces are optional if there's only one expression in an 'if' branch. */

// rewriting eval using 'when'

fun evalWhen(e: Expr): Int =
        when (e) {
            is Num ->
                e.value
            is Sum ->
                evalWhen(e.right) + eval(e.left)
            else ->
                throw IllegalArgumentException("Unknown expression")
        }

/* blocks as branches of 'if' and 'when'
* 'if' and 'when' can have blocks as branches. the last expression in the block
* is the result
*
* Important: "the last expression in a block is the result"
* */

fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }
fun main(args: Array<String>) {
    //println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    //println(evalIf(Sum(Num(1), Num(2))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}