package D1.Bank;

public class BankApp {

    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount acc1 = new BankAccount("CH93-0000-0000-0001", "Anna Muster");
        BankAccount acc2 = new BankAccount("CH93-0000-0000-0002", "Ben Beispiel");

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        acc1.deposit(1000.0);
        acc2.deposit(500.0);

        System.out.println("=== Kontostände vor Transfer ===");
        bank.printAllAccounts();

        System.out.println("\nAnna überweist 300 CHF an Ben...\n");
        acc1.transferTo(acc2, 300.0);

        System.out.println("=== Kontostände nach Transfer ===");
        bank.printAllAccounts();
    }
}
