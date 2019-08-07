package nickson.vehicle;

public interface Vehicle {
    void changeGear(int newGear);
    void speedUp(int increment);
    void applyBrakes(int decrement);
}