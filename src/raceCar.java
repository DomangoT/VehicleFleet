
public class raceCar extends Vehicle {
    private int horsepower;
    private boolean turboEnabled;
    public raceCar(String make, int topSpeed, double fuel,
                   int horsepower) {
        super(make, topSpeed, fuel);
        this.horsepower = horsepower;
        this.turboEnabled = false;
    }
    public void activateTurbo() {
        if (!turboEnabled) {
            turboEnabled = true;
            System.out.println("Turbo boost activated");
        } else {
            System.out.println("Turbo is already active.");
        }
    }
    @Override public String reFuel() {
        return "The race car is refueling with racing fuel.";
    }
    @Override public String describe() {
        return getMake() + " race car with " +
                horsepower + " horsepower.";
    }
    @Override public double getMPG() {
        return 10;
    }
}
