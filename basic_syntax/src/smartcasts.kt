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

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}