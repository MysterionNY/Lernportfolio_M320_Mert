package Q3H;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ExportUtil {
    private ExportUtil() {}

    public static void exportReportToTextFile(DeliveryReport report, Path file) throws IOException {
        Files.writeString(file, report.toString(), StandardCharsets.UTF_8);
    }

    public static void exportPackageHistoryToCsv(ParcelPackage p, Path file) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("timestamp,type,location,note\n");
        for (ScanEvent e : p.getHistory()) {
            sb.append(csv(e.getTimestamp().toString())).append(',')
              .append(csv(e.getType().name())).append(',')
              .append(csv(e.getLocation())).append(',')
              .append(csv(e.getNote())).append('\n');
        }
        Files.writeString(file, sb.toString(), StandardCharsets.UTF_8);
    }

    private static String csv(String s) {
        if (s == null) return "";
        String escaped = s.replace("\"", "\"\"");
        if (escaped.contains(",") || escaped.contains("\n") || escaped.contains("\"")) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}
