package V3A;

public class Stock {

    private String name;
    private int amount;

    public Stock(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " (" + amount + " Stück)";
    }
}
