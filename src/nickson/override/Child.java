package nickson.override;

public class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child's show()");
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.show();

        /* Runtime polymorphism: version of a method to be executed is determined
         * by the object that is used to invokes it
         */
        Parent child = new Child();
        child.show();
    }
}
