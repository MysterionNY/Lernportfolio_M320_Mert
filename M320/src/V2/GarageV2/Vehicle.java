package V2.GarageV2;

public abstract class Vehicle {
    private String licensePlate;
    private boolean repaired;
    private double baseCost;

    public Vehicle(String licensePlate, double baseCost) {
        this.licensePlate = licensePlate;
        this.baseCost = baseCost;
        this.repaired = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    protected double getBaseCost() {
        return baseCost;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public abstract double calculateRepairCost();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + licensePlate + "]";
    }
}

