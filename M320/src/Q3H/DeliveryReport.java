package Q3H;

import java.util.Objects;

public final class DeliveryReport {
    private final int totalPackages;
    private final int deliveredCount;
    private final int stuckCount;
    private final String mostCommonLastLocation; // may be null
    private final MyLinkedList<ParcelPackage> stuckPackages;

    public DeliveryReport(int totalPackages, int deliveredCount, int stuckCount,
                          String mostCommonLastLocation, MyLinkedList<ParcelPackage> stuckPackages) {
        this.totalPackages = totalPackages;
        this.deliveredCount = deliveredCount;
        this.stuckCount = stuckCount;
        this.mostCommonLastLocation = mostCommonLastLocation;
        this.stuckPackages = Objects.requireNonNull(stuckPackages, "stuckPackages");
    }

    public int getTotalPackages() { return totalPackages; }
    public int getDeliveredCount() { return deliveredCount; }
    public int getStuckCount() { return stuckCount; }
    public String getMostCommonLastLocation() { return mostCommonLastLocation; }
    public MyLinkedList<ParcelPackage> getStuckPackages() { return stuckPackages; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Delivery Report ===\n");
        sb.append("Total packages: ").append(totalPackages).append("\n");
        sb.append("Delivered: ").append(deliveredCount).append("\n");
        sb.append("Stuck: ").append(stuckCount).append("\n");
        sb.append("Most common last location: ").append(mostCommonLastLocation).append("\n");
        sb.append("\n-- Stuck packages --\n");
        for (ParcelPackage p : stuckPackages) {
            sb.append(p.summary()).append("\n");
        }
        return sb.toString();
    }
}
