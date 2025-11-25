package D2D;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auction {
    private final List<Lot> lots = new ArrayList<>();

    public void addLot(int lotNumber, String description, LocalDateTime endTime) {
        lots.add(new Lot(lotNumber, description, endTime));
    }

    public Lot findLot(int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getLotNumber() == lotNumber) {
                return lot;
            }
        }
        return null;
    }

    public boolean makeBid(int lotNumber, Person person, double amount) {
        Lot lot = findLot(lotNumber);
        if (lot == null) {
            System.out.println("Lot " + lotNumber + " not found.");
            return false;
        }
        Bid bid = new Bid(person, amount);
        return lot.placeBid(bid);
    }

    public void printLots() {
        for (Lot lot : lots) {
            System.out.println(lot);
        }
    }
}
