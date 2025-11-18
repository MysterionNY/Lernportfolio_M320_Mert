package D1.Bank;

public class BankAccount {
    private final String iban;
    private final String ownerName;
    private double balance;

    public BankAccount(String iban, String ownerName) {
        this.iban = iban;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public String getIban() {
        return iban;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Betrag muss positiv sein");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Betrag muss positiv sein");
        }
        if (amount > balance) {
            System.out.println("Nicht genügend Guthaben auf Konto " + iban);
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, double amount) {
        if (withdraw(amount)) {
            target.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "IBAN='" + iban + '\'' +
                ", Besitzer='" + ownerName + '\'' +
                ", Kontostand=" + balance +
                '}';
    }
}
