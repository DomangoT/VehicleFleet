
public class Motorcycle extends Vehicle implements Maintenance {
    private int engineCC;
    private boolean hasSidecar;

    public Motorcycle(String make, int topSpeed, double fuel,
                      int engineCC, boolean hasSidecar) {
        super(make, topSpeed, fuel);
        this.engineCC = engineCC;
        this.hasSidecar = hasSidecar;
    }

    public void performWheelie() {
        if (hasSidecar) {
            System.out.println("Cannot perform a wheelie with a sidecar");
        } else {
            System.out.println(getMake() + " performs a wheelie");
        }
    }
    @Override public String performMaintenance() {
        return "Motorcycle maintenance: checking tires and chain.";
    }
    @Override public String reFuel() {
        return "The motorcycle is refueling with gasoline.";
    }

    @Override public String describe() {
        return getMake() + " motorcycle with a " +
                engineCC + "cc engine.";
    }
    @Override public double getMPG() {
        return 50;
    }
}
