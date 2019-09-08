package nickson.generics;

import java.util.ArrayList;
import java.util.List;

/* Java is a type safe language
 * - It is better to pick out errors at compile time, than at runtime.
 * - Let's say you want to use the collections API, and create a List.
 * - One can add any object into the list, but what if you want to restrict your list to only integers?
 * - Generics
 */

class Container<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void show() {
        System.out.println(value.getClass().getName());
    }
}

/* What if we wanted to limit our container to only Number classes?
 * Soln: we can bind a type to the generic
 */
class NumberContainer<T extends Number> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /* <? extends T>
     * - accept all subclasses of T, in our case int, float, double
     *
     * <? super T>
     * - accept all superclasses of T
     */
    public void demo(ArrayList<? extends T> obj) {
        // TODO things
    }
}

public class GenericsExample {
    public static void main(String[] args) {
        int value = 5;  // we must know the type of the variable at compile time: Type Safety.
        List values = new ArrayList();

        /* we can add to values any object because we do not explicitly say what type of values to hold */
        values.add(value);
        values.add("Nickson"); // legal but our intention is to use integer values, how do we catch this at compile
                               // time?

        List<Integer> integerValues = new ArrayList<>();
        integerValues.add(value);
        /* attempting to add a non int results in compile time error: incompatible types
         * this has been achieved by using the concept of generics
         *
         * integerValues.add("Nickson"); // error
         */

        Container<Integer> obj = new Container<>();
        obj.value = 1;
        obj.show();

        Container<String> obj2 = new Container<>();
        obj2.value = "Nickson";
        obj2.show();

        NumberContainer<Integer> obj3 =  new NumberContainer<>();
        obj3.setValue(3);
        System.out.println(obj3.getValue());

        NumberContainer<Double> obj4 =  new NumberContainer<>();
        obj4.setValue(3.3);
        System.out.println(obj4.getValue());
    }
}
