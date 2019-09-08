package nickson.generics;

import java.util.ArrayList;
import java.util.List;

/* Java is a type safe language
 * - It is better to pick out errors at compile time, than at runtime.
 * - Let's say you want to use the collections API, and create a List.
 * - One can add any object into the list, but what if you want to restrict your list to only integers?
 * - Generics
 */
public class GenericsExample {
    public static void main(String[] args) {
        int value = 5;  // we must know the type of the variable at compile time: Type Safety.
        List values = new ArrayList();

        /* we can add to values any object because we do not explicitly say what type of values to hold */
        values.add(value);
        values.add("Nickson"); // legal but our intention is to use integer values, how do we catch this at compile
                               // time?

        List<Integer> integerValues = new ArrayList<Integer>();
        integerValues.add(value);
        /* attempting to add a non int results in compile time error: incompatible types
         * this has been achieved by using the concept of generics
         */
        
        //integerValues.add("Nickson"); // error
    }

}
