
public class Car extends Vehicle {
    private int passengerCapacity;
    public Car(String make, int topSpeed, double fuel,
               int passengerCapacity) {
        super(make, topSpeed, fuel);
        this.passengerCapacity = passengerCapacity;
    }
    @Override public String reFuel() {
        return "The car is refueling with gasoline.";
    }
    @Override public String describe() {
        return getMake() + " car with " +
                passengerCapacity + " seats.";
    }
    @Override public double getMPG() {
        return 30;
    }
}
