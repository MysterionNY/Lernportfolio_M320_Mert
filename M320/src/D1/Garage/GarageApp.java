package D1.Garage;

public class GarageApp {

    public static void main(String[] args) {
        Garage garage = new Garage();
        Vehicle v1 = new Vehicle("ZH 12345", "VW Golf");
        Vehicle v2 = new Vehicle("ZH 98765", "BMW 3er");
        Vehicle v3 = new Vehicle("AG 55555", "Tesla Model 3");

        garage.registerVehicle(v1);
        garage.registerVehicle(v2);
        garage.registerVehicle(v3);

        System.out.println("=== Alle Fahrzeuge (vor Reparatur) ===");
        garage.printAllVehicles();

        garage.repairVehicle("ZH 12345", 450.00);
        garage.repairVehicle("AG 55555", 1200.50);

        System.out.println("\n=== Reparierte Fahrzeuge ===");
        for (Vehicle v : garage.getRepairedVehicles()) {
            System.out.println(v);
        }

        System.out.println("\nGesamte Reparaturkosten: " + garage.getTotalRepairCosts() + " CHF");
    }
}
