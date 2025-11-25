package V2.GarageV2;

public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String licensePlate, double baseCost, int numberOfDoors) {
        super(licensePlate, baseCost);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Autos mit mehr als 3 Türen erhalten einen Aufpreis von 10%
     */
    @Override
    public double calculateRepairCost() {
        double cost = getBaseCost();
        if (numberOfDoors > 3) {
            cost *= 1.10;
        }
        return cost;
    }
}

