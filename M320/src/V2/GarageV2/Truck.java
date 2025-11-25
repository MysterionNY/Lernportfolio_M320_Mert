package V2.GarageV2;

public class Truck extends Vehicle {

    private double loadCapacityInTons;

    public Truck(String licensePlate, double baseCost, double loadCapacityInTons) {
        super(licensePlate, baseCost);
        this.loadCapacityInTons = loadCapacityInTons;
    }

    /**
     * Trucks mit jeder extra Tonne gewicht erhalten einen Aufpreis von 50.-
     */
    @Override
    public double calculateRepairCost() {
        double cost = getBaseCost();
        cost += loadCapacityInTons * 50;
        return cost;
    }
}

