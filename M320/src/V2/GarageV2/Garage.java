package V2.GarageV2;

import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert eine Garage, welche verschiedene Fahrzeuge verwalten
 * und deren Reparaturen durchführen kann.
 *
 * Zeigt Polymorphismus über die Liste von {@link Vehicle}.
 */
public class Garage {

    /**
     * Alle Fahrzeuge, die aktuell in der Garage registriert sind.
     */
    private List<Vehicle> vehicles = new ArrayList<>();

    /**
     * Registriert ein neues Fahrzeug in der Garage.
     *
     * @param vehicle das zu registrierende Fahrzeug
     */
    public void registerVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Repariert alle registrierten Fahrzeuge.
     * <p>
     * Für jedes Fahrzeug wird {@link Vehicle#calculateRepairCost()} aufgerufen
     * und der Reparaturstatus auf {@code true} gesetzt.
     * Die berechneten Kosten werden in der Konsole ausgegeben.
     */
    public void repairAll() {
        if (vehicles.isEmpty()) {
            System.out.println("Keine Fahrzeuge in der Garage.");
            return;
        }

        for (Vehicle v : vehicles) {
            double cost = v.calculateRepairCost();
            v.setRepaired(true);
            System.out.println("Repariert: " + v + ", Kosten: " + cost);
        }
    }

    /**
     * Gibt alle bereits reparierten Fahrzeuge in der Konsole aus.
     */
    public void printRepairedVehicles() {
        System.out.println("Bereits reparierte Fahrzeuge:");
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.isRepaired()) {
                System.out.println(" - " + v);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" (keine reparierten Fahrzeuge)");
        }
    }

    /**
     * Gibt alle registrierten Fahrzeuge mit ihrem Reparaturstatus in der Konsole aus.
     */
    public void printAllVehicles() {
        System.out.println("Alle Fahrzeuge in der Garage:");
        if (vehicles.isEmpty()) {
            System.out.println(" (keine Fahrzeuge registriert)");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(" - " + v + " | repariert: " + (v.isRepaired() ? "ja" : "nein"));
        }
    }
}
