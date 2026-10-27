
public abstract class Vehicle {
    protected int topSpeed;
    private String make;
    private double miles;
    private double fuel;

    public Vehicle(String make, int topSpeed, double fuel) {
        this.make = make;
        this.topSpeed = topSpeed;
        this.fuel = fuel;
        this.miles = 0;
    }
    public boolean drive(double distance) {
        if (distance <= 0) {
            System.out.println("Distance must be positive.");
            return false;
        }
        double fuelNeeded = distance / getMPG();
        if (fuel < fuelNeeded) {
            System.out.println(getMake() + " does not have enough fuel");
            return false;
        }
        fuel -= fuelNeeded;
        miles += distance;
        System.out.println(getMake() + " drove " + distance + " miles.");
        System.out.println("Fuel remaining: " + fuel);
        return true;
    }
    public double getMPG() {
        return 25;
    }
    public String getMake() {
        return make;
    }
    public int getTopSpeed() {
        return topSpeed;
    }
    public double getMiles() {
        return miles;
    }
    public double getFuel() {
        return fuel;
    }
    public void addMiles(double distance) {if (distance > 0) {miles += distance;
        }
    }
    public void setFuel(double fuel) {
        if (fuel >= 0) {
            this.fuel = fuel;
        }
    }
    public abstract String reFuel();
    public abstract String describe();
}
