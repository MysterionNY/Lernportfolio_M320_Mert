package D2D;

import java.time.LocalDateTime;

public class Bid {
    private final Person bidder;
    private final double amount;
    private final LocalDateTime time;

    public Bid(Person bidder, double amount) {
        this(bidder, amount, LocalDateTime.now());
    }

    public Bid(Person bidder, double amount, LocalDateTime time) {
        this.bidder = bidder;
        this.amount = amount;
        this.time = time;
    }

    public Person getBidder() {
        return bidder;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return amount + " CHF by " + bidder + " at " + time;
    }
}

