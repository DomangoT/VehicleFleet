import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> fleet = loadFleet();
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
        System.out.println("=== SAVING FLEET ===");
        System.out.println("Working directory: "
                + System.getProperty("user.dir"));
        saveFleet(fleet);

        System.out.println("=== LOADING SAVED FLEET ===");

        fleet = loadFleet();

        System.out.println("=== LOADED FLEET ===");

        for (Vehicle v : fleet) {
            System.out.println(v.describe());
        }

        System.out.println("Total loaded: " + fleet.size());



    }

    public static ArrayList<Vehicle> loadFleet() {
        ArrayList<Vehicle> loadedFleet = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("fleet.csv"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                String type = parts[0];
                String make = parts[1];
                int topSpeed = Integer.parseInt(parts[2]);
                double fuel = Double.parseDouble(parts[3]);
                if (type.equals("Car")) {
                    int seats = Integer.parseInt(parts[4]);
                    loadedFleet.add(
                            new Car(make, topSpeed, fuel, seats)
                    );
                } else if (type.equals("Truck")) {
                    double capacity = Double.parseDouble(parts[4]);
                    loadedFleet.add(
                            new Truck(make, topSpeed, fuel, capacity)
                    );
                } else if (type.equals("Motorcycle")) {
                    int engineCC = Integer.parseInt(parts[4]);
                    boolean sidecar = Boolean.parseBoolean(parts[5]);
                    loadedFleet.add(
                            new Motorcycle(make, topSpeed, fuel,
                                    engineCC, sidecar)
                    );
                } else if (type.equals("raceCar")) {
                    int horsepower = Integer.parseInt(parts[4]);
                    loadedFleet.add(
                            new raceCar(make, topSpeed, fuel, horsepower)
                    );
                } else if (type.equals("teslaRoadster")) {
                    int seats = Integer.parseInt(parts[4]);
                    int range = Integer.parseInt(parts[5]);
                    loadedFleet.add(
                            new teslaRoadster(topSpeed, fuel, seats, range)
                    );
                }
            }
            System.out.println("Fleet loaded successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("No saved fleet found.");
        }

        return loadedFleet;
    }

    public static void saveFleet(ArrayList<Vehicle> fleet) {
        try (FileWriter writer = new FileWriter("fleet.csv")) {
            for (Vehicle v : fleet) {
                writer.write(v.toCsv() + "\n");
            }
            System.out.println("Fleet saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving fleet: " + e.getMessage());
        }
    }
}
