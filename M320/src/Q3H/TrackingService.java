package Q3H;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TrackingService {
    private final MyLinkedList<ParcelPackage> packages = new MyLinkedList<>();

    public ParcelPackage registerPackage(String trackingId, String recipientName, String address, LocalDateTime now, String location) {
        if (findByTrackingId(trackingId) != null) {
            throw new IllegalArgumentException("Tracking ID already exists: " + trackingId);
        }
        ParcelPackage p = new ParcelPackage(trackingId, recipientName, address);
        p.addScan(new ScanEvent(ScanType.CREATED, now, requireNonBlank(location, "location"), "Package registered"));
        packages.add(p);
        return p;
    }

    public void scanPackage(String trackingId, ScanEvent event) {
        ParcelPackage p = findByTrackingId(trackingId);
        if (p == null) {
            throw new IllegalArgumentException("Unknown trackingId: " + trackingId);
        }
        p.addScan(event);
    }

    public ParcelPackage findByTrackingId(String trackingId) {
        if (trackingId == null) return null;
        for (ParcelPackage p : packages) {
            if (trackingId.equals(p.getTrackingId())) return p;
        }
        return null;
    }

    public MyLinkedList<ParcelPackage> listStuckPackages(Duration maxAge, LocalDateTime now) {
        Objects.requireNonNull(maxAge, "maxAge");
        Objects.requireNonNull(now, "now");

        MyLinkedList<ParcelPackage> stuck = new MyLinkedList<>();
        for (ParcelPackage p : packages) {
            ScanType status = p.currentStatus();
            if (status == null) continue;

            // stuck definition:
            // - not DELIVERED
            // - last scan older than maxAge
            if (status != ScanType.DELIVERED) {
                LocalDateTime last = p.lastScanTime();
                if (last != null) {
                    Duration age = Duration.between(last, now);
                    if (age.compareTo(maxAge) > 0) {
                        stuck.add(p);
                    }
                }
            }
        }
        return stuck;
    }

    public DeliveryReport deliveryReport(Duration stuckAge, LocalDateTime now) {
        Objects.requireNonNull(stuckAge, "stuckAge");
        Objects.requireNonNull(now, "now");

        int total = packages.size();
        int delivered = 0;

        Map<String, Integer> locationCounts = new HashMap<>();
        for (ParcelPackage p : packages) {
            if (p.currentStatus() == ScanType.DELIVERED) delivered++;

            String loc = p.lastLocation();
            if (loc != null && !loc.isBlank()) {
                locationCounts.put(loc, locationCounts.getOrDefault(loc, 0) + 1);
            }
        }

        MyLinkedList<ParcelPackage> stuck = listStuckPackages(stuckAge, now);
        int stuckCount = stuck.size();

        String mostCommon = null;
        int best = 0;
        for (Map.Entry<String, Integer> e : locationCounts.entrySet()) {
            if (e.getValue() > best) {
                best = e.getValue();
                mostCommon = e.getKey();
            }
        }

        return new DeliveryReport(total, delivered, stuckCount, mostCommon, stuck);
    }

    public MyLinkedList<ParcelPackage> getAllPackages() {
        return packages;
    }

    private static String requireNonBlank(String s, String field) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(field + " must not be blank.");
        return s;
    }
}
