package nickson.vehicle;

public class Bicycle implements Vehicle{
    int speed;
    int gear;

    @Override
    public void changeGear(int newGear) {
        gear = newGear;
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
    }

    public void printStates() {
        System.out.println("Speed: " + speed + "\nGear: " + gear);
    }

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(4);
        bicycle.applyBrakes(1);
        System.out.println("Bicycle present state: ");
        bicycle.printStates();
    }
}