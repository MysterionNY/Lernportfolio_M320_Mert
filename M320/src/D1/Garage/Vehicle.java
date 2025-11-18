package D1.Garage;

public class Vehicle {
    private final String licensePlate;
    private final String model;
    private boolean repaired;
    private double repairCost;

    public Vehicle(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.repaired = false;
        this.repairCost = 0.0;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void markAsRepaired(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Kosten dürfen nicht negativ sein.");
        }
        this.repaired = true;
        this.repairCost = cost;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "Kennzeichen='" + licensePlate + '\'' +
                ", Modell='" + model + '\'' +
                ", repariert=" + repaired +
                ", Kosten=" + repairCost +
                '}';
    }
}
