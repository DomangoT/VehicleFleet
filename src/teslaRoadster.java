
public class teslaRoadster extends Car {
    private int batteryRange;
    public teslaRoadster(int topSpeed, double fuel,
                         int passengerCapacity, int batteryRange) {
        super("Tesla", topSpeed, fuel, passengerCapacity);
        this.batteryRange = batteryRange;
    }
    @Override public String reFuel() {
        return "The Tesla Roadster is charging its battery";
    }
    @Override public String describe() {
        return "Tesla Roadster with a range of " +
                batteryRange + " miles.";
    }
    @Override public double getMPG() {
        return 100;
    }
}
