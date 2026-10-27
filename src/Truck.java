
public class Truck extends Vehicle implements Maintenance{
    private double cargoCapacity;
    private double cargoWeight;
    public Truck(String make, int topSpeed, double fuel,
                 double cargoCapacity) {
        super(make, topSpeed, fuel);
        this.cargoCapacity = cargoCapacity;
        this.cargoWeight = 0;
    }
    @Override public String performMaintenance() {
        return "Truck maintenance: inspecting brakes and cargo equipment.";
    }
    public void loadCargo(double weight) {
        if (weight <= 0) {
            System.out.println("Invalid cargo weight.");
        } else if (cargoWeight + weight > cargoCapacity) {
            System.out.println("Truck is overloaded!");
        } else {
            cargoWeight += weight;
            System.out.println("Cargo loaded successfully.");
        }
    }
    @Override public String reFuel() {
        return "The truck is refueling with diesel.";
    }
    @Override public String describe() {
        return getMake() + " truck carrying " +
                cargoWeight + " tons of cargo.";
    }
    @Override public double getMPG() {
        return 15;
    }

}
