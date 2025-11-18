package D1.Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccountByIban(String iban) {
        for (BankAccount acc : accounts) {
            if (acc.getIban().equals(iban)) {
                return acc;
            }
        }
        return null;
    }

    public void printAllAccounts() {
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }
}
