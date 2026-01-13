package Q3H;

import java.time.LocalDateTime;
import java.util.Objects;

public final class ScanEvent {
    private final ScanType type;
    private final LocalDateTime timestamp;
    private final String location;
    private final String note;

    public ScanEvent(ScanType type, LocalDateTime timestamp, String location, String note) {
        this.type = Objects.requireNonNull(type, "type");
        this.timestamp = Objects.requireNonNull(timestamp, "timestamp");
        this.location = Objects.requireNonNull(location, "location");
        this.note = note;
    }

    public ScanType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        String n = (note == null || note.isBlank()) ? "" : " | note=" + note;
        return timestamp + " | " + type + " | " + location + n;
    }
}
