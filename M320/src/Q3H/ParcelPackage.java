package Q3H;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParcelPackage {
    private final String trackingId; // unique
    private final String recipientName;
    private final String address;
    private final MyLinkedList<ScanEvent> history = new MyLinkedList<>();

    public ParcelPackage(String trackingId, String recipientName, String address) {
        this.trackingId = requireNonBlank(trackingId, "trackingId");
        this.recipientName = requireNonBlank(recipientName, "recipientName");
        this.address = requireNonBlank(address, "address");
    }

    public String getTrackingId() { return trackingId; }
    public String getRecipientName() { return recipientName; }
    public String getAddress() { return address; }
    public MyLinkedList<ScanEvent> getHistory() { return history; }

    public void addScan(ScanEvent event) {
        Objects.requireNonNull(event, "event");
        ScanEvent last = lastScan();
        if (last == null) {
            if (event.getType() != ScanType.CREATED) {
                throw new IllegalArgumentException("First scan must be CREATED.");
            }
            history.add(event);
            return;
        }

        if (event.getTimestamp().isBefore(last.getTimestamp())) {
            throw new IllegalArgumentException("Timestamp cannot go backwards.");
        }

        ScanType lastType = last.getType();
        ScanType newType = event.getType();
        if (lastType == ScanType.DELIVERED) {
            boolean allowedSameDeliveredNote =
                    newType == ScanType.DELIVERED &&
                    event.getNote() != null &&
                    !event.getNote().isBlank();

            if (!allowedSameDeliveredNote) {
                throw new IllegalArgumentException("Package already DELIVERED. Only a DELIVERED note scan is allowed.");
            }
        }
        if (newType.ordinal() < lastType.ordinal()) {
            throw new IllegalArgumentException("Status cannot go backwards (" + lastType + " -> " + newType + ").");
        }

        if (newType == ScanType.CREATED && history.size() > 0) {
            throw new IllegalArgumentException("CREATED can only be the first scan.");
        }

        history.add(event);
    }

    public ScanType currentStatus() {
        ScanEvent last = lastScan();
        return last == null ? null : last.getType();
    }

    public LocalDateTime lastScanTime() {
        ScanEvent last = lastScan();
        return last == null ? null : last.getTimestamp();
    }

    public String lastLocation() {
        ScanEvent last = lastScan();
        return last == null ? null : last.getLocation();
    }

    public String summary() {
        return "TrackingId=" + trackingId +
                " | " + recipientName +
                " | " + address +
                " | status=" + currentStatus() +
                " | lastScan=" + lastScanTime() +
                " | lastLocation=" + lastLocation();
    }

    public void printFullHistory() {
        System.out.println("=== History for " + trackingId + " ===");
        for (ScanEvent e : history) {
            System.out.println(e);
        }
    }

    private ScanEvent lastScan() {
        if (history.size() == 0) return null;
        return history.get(history.size() - 1);
    }

    private static String requireNonBlank(String s, String field) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(field + " must not be blank.");
        return s;
    }
}
