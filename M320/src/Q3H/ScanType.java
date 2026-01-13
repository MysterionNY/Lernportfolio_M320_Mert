package Q3H;

public enum ScanType {
    CREATED,
    PICKED_UP,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERED,
    LOST;

    public boolean isTerminal() {
        return this == DELIVERED || this == LOST;
    }
}
