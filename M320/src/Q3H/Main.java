package Q3H;

import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TrackingService service = new TrackingService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                \n=== Package Tracking CLI ===
                1) Register package
                2) Scan update
                3) Find by tracking ID + print history
                4) List stuck packages
                5) Show delivery report
                6) Export report to TXT
                7) Export package history to CSV
                0) Exit
                """);

            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Tracking ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Recipient name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Address: ");
                    String addr = sc.nextLine().trim();
                    System.out.print("Initial location: ");
                    String loc = sc.nextLine().trim();

                    ParcelPackage p = service.registerPackage(id, name, addr, LocalDateTime.now(), loc);
                    System.out.println("Registered: " + p.summary());
                }
                case "2" -> {
                    System.out.print("Tracking ID: ");
                    String id = sc.nextLine().trim();

                    System.out.println("ScanType options: CREATED, PICKED_UP, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED, LOST");
                    System.out.print("Type: ");
                    ScanType type = ScanType.valueOf(sc.nextLine().trim());

                    System.out.print("Location: ");
                    String loc = sc.nextLine().trim();

                    System.out.print("Note (optional): ");
                    String note = sc.nextLine();
                    if (note != null && note.isBlank()) note = null;

                    service.scanPackage(id, new ScanEvent(type, LocalDateTime.now(), loc, note));
                    System.out.println("Scan added.");
                }
                case "3" -> {
                    System.out.print("Tracking ID: ");
                    String id = sc.nextLine().trim();
                    ParcelPackage p = service.findByTrackingId(id);
                    if (p == null) {
                        System.out.println("Not found.");
                    } else {
                        System.out.println(p.summary());
                        p.printFullHistory();
                    }
                }
                case "4" -> {
                    Duration maxAge = askHours(sc);
                    MyLinkedList<ParcelPackage> stuck = service.listStuckPackages(maxAge, LocalDateTime.now());
                    System.out.println("Stuck count: " + stuck.size());
                    for (ParcelPackage p : stuck) System.out.println(p.summary());
                }
                case "5" -> {
                    Duration maxAge = askHours(sc);
                    DeliveryReport report = service.deliveryReport(maxAge, LocalDateTime.now());
                    System.out.println(report);
                }
                case "6" -> {
                    Duration maxAge = askHours(sc);
                    DeliveryReport report = service.deliveryReport(maxAge, LocalDateTime.now());
                    System.out.print("File path (e.g. report.txt): ");
                    Path file = Path.of(sc.nextLine().trim());
                    ExportUtil.exportReportToTextFile(report, file);
                    System.out.println("Exported report to: " + file.toAbsolutePath());
                }
                case "7" -> {
                    System.out.print("Tracking ID: ");
                    String id = sc.nextLine().trim();
                    ParcelPackage p = service.findByTrackingId(id);
                    if (p == null) {
                        System.out.println("Not found.");
                        break;
                    }
                    System.out.print("CSV file path (e.g. history.csv): ");
                    Path file = Path.of(sc.nextLine().trim());
                    ExportUtil.exportPackageHistoryToCsv(p, file);
                    System.out.println("Exported history to: " + file.toAbsolutePath());
                }
                case "0" -> {
                    System.out.println("Bye.");
                    return;
                }
                default -> System.out.println("Unknown choice.");
            }
        }
    }

    private static Duration askHours(Scanner sc) {
        System.out.print("Stuck threshold (hours): ");
        long hours = Long.parseLong(sc.nextLine().trim());
        return Duration.ofHours(hours);
    }
}
