package D2D;

import java.time.LocalDateTime;

public class Lot {
    private final int lotNumber;
    private final String description;
    private final LocalDateTime endTime;
    private Bid highestBid;

    public Lot(int lotNumber, String description, LocalDateTime endTime) {
        this.lotNumber = lotNumber;
        this.description = description;
        this.endTime = endTime;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public boolean placeBid(Bid bid) {
        if (LocalDateTime.now().isAfter(endTime)) {
            System.out.println("Lot " + lotNumber + " is already closed.");
            return false;
        }

        if (highestBid == null || bid.getAmount() > highestBid.getAmount()) {
            highestBid = bid;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lot " + lotNumber + " (" + description + "), end: " + endTime +
                ", current highest bid: " + (highestBid == null ? "none" : highestBid);
    }
}
