
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("Honda", 120, 100, 5));
        fleet.add(new Truck("Ford", 100, 100, 3.5));
        fleet.add(new Motorcycle("Yamaha", 160, 100, 600, false));
        fleet.add(new raceCar("Ferrari", 220, 100, 800));
        fleet.add(new teslaRoadster(250, 100, 4, 620));
        System.out.println("=== VEHICLE FLEET ===");
        for (Vehicle v : fleet) {
            System.out.println(v.describe());
            System.out.println(v.reFuel());
            System.out.println();
        }
        System.out.println("=== FLEET ROAD TRIP ===");
        for (Vehicle v : fleet) {
            System.out.println(v.describe());
            v.drive(100);
            System.out.println("Total miles: " + v.getMiles());
            System.out.println("Fuel efficiency: " + v.getMPG());
            System.out.println();
        }
        System.out.println("=== VEHICLE RACE ===");
        Vehicle winner = fleet.get(0);
        for (Vehicle v : fleet) {
            System.out.println(v.getMake() + " top speed: " + v.getTopSpeed() + " MPH");
            if (v.getTopSpeed() > winner.getTopSpeed()) {
                winner = v;
            }
        }
        System.out.println();
        System.out.println("Race winner: " + winner.describe());
        System.out.println("Winning speed: " + winner.getTopSpeed() + " MPH");
        System.out.println("=== SPECIAL ABILITIES ===");
        Truck truck = new Truck("Chevrolet", 110, 100, 5);
        truck.loadCargo(3);
        Motorcycle bike = new Motorcycle("Kawasaki", 180, 100, 1000, false);
        bike.performWheelie();
        raceCar racer = new raceCar("McLaren", 230, 100, 900);
        racer.activateTurbo();
        System.out.println("=== MAINTENANCE ===");
        Maintenance[] serviceVehicles = {truck, bike};
        for (Maintenance vehicle : serviceVehicles) {
            System.out.println(vehicle.performMaintenance());
        }
        System.out.println("=== FLEET STATISTICS ===");
        double totalMiles = 0;
        double totalFuel = 0;
        double totalSpeed = 0;
        for (Vehicle v : fleet) {
            totalMiles += v.getMiles();
            totalFuel += v.getFuel();
            totalSpeed += v.getTopSpeed();
        }
        System.out.println("Total vehicles: " + fleet.size());
        System.out.println("Total miles driven: " + totalMiles);
        System.out.println("Total fuel/energy units: " + totalFuel);
        System.out.println("Average top speed: "
                + (totalSpeed / fleet.size()) + " MPH");
    }
}
