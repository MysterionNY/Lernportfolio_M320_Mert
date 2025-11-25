package V2.GarageV2;

public class Motorcycle extends Vehicle {

    private boolean hasSidecar;

    public Motorcycle(String licensePlate, double baseCost, boolean hasSidecar) {
        super(licensePlate, baseCost);
        this.hasSidecar = hasSidecar;
    }

    /**
     * Motorräder mit einem angeschlossenen Fahrzeug erhalten einen Aufpreis von 15%
     */
    @Override
    public double calculateRepairCost() {
        double cost = getBaseCost();
        if (hasSidecar) {
            cost *= 1.15;
        }
        return cost;
    }
}

