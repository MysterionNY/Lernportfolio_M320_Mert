package D1.Garage;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void registerVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void repairVehicle(String licensePlate, double cost) {
        Vehicle v = findByLicensePlate(licensePlate);
        if (v != null) {
            v.markAsRepaired(cost);
        } else {
            System.out.println("Fahrzeug mit Kennzeichen " + licensePlate + " nicht gefunden.");
        }
    }

    public Vehicle findByLicensePlate(String licensePlate) {
        for (Vehicle v : vehicles) {
            if (v.getLicensePlate().equals(licensePlate)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehicle> getRepairedVehicles() {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.isRepaired()) {
                result.add(v);
            }
        }
        return result;
    }

    public double getTotalRepairCosts() {
        double sum = 0.0;
        for (Vehicle v : vehicles) {
            sum += v.getRepairCost();
        }
        return sum;
    }

    public void printAllVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
