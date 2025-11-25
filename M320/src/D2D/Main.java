package D2D;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction();

        auction.addLot(1, "Gaming Laptop", LocalDateTime.now().plusMinutes(10));
        auction.addLot(2, "Smartphone", LocalDateTime.now().plusMinutes(20));

        Person alice = new Person("Alice");
        Person bob   = new Person("Bob");

        auction.makeBid(1, alice, 500.0);
        auction.makeBid(1, bob,   550.0);
        auction.makeBid(2, bob,   300.0);

        auction.printLots();
    }
}