package nickson

/* Kotlin functions are 'first-class' functions. They can:
 * 1. be stored in variables and data structures
 * 2. be passed as arguments to and returned from other 'higher-order' functions
 * 3. Can be operated on in any way that is possible for other non-function values
 * */

/* Higher-Order Functions: is a function that takes functions as parameters, or returns a function */

/* Function Type: used to represent the type of a function (in contrast to
 * interfaces in Java)
 * syntax:
 *      (Type, Type) -> ReturnType
 * */

fun exampleFxTypes(){
    /*
     * Function Types can be instantiated in multiple ways:
     * 1. Lambda expressions
     * */
    val filter: (Int) -> Boolean = { it < 2}
}

fun main(){

}