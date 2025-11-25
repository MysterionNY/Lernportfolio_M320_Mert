package V2.GarageV2;

import java.util.Scanner;

/**
 * Konsolenanwendung zur Demonstration der Garagen-Funktionalität.
 * <p>
 * Ermöglicht das interaktive Registrieren, Reparieren
 * und Anzeigen von Fahrzeugen.
 */
public class GarageApp {

    /**
     * Gemeinsamer {@link Scanner} für alle Benutzereingaben.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Einstiegspunkt der Anwendung.
     *
     * @param args Kommandozeilenargumente (werden hier nicht verwendet)
     */
    public static void main(String[] args) {
        Garage garage = new Garage();
        boolean running = true;

        while (running) {
            System.out.println("1) Fahrzeug registrieren");
            System.out.println("2) Alle Fahrzeuge reparieren");
            System.out.println("3) Reparierte Fahrzeuge anzeigen");
            System.out.println("4) Alle Fahrzeuge anzeigen");
            System.out.println("0) Programm beenden");
            System.out.print("Ihre Auswahl: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> registerVehicleInteractive(garage);
                case 2 -> garage.repairAll();
                case 3 -> garage.printRepairedVehicles();
                case 4 -> garage.printAllVehicles();
                case 0 -> {
                    System.out.println("Programm wird beendet. Auf Wiedersehen!");
                    running = false;
                }
                default -> System.out.println("Ungültige Auswahl!");
            }
        }

        scanner.close();
    }

    /**
     * Führt den Dialog zur Registrierung eines neuen Fahrzeugs.
     * <p>
     * Der Benutzer wählt den Fahrzeugtyp und gibt die nötigen Daten ein.
     *
     * @param garage die Garage, in der das neue Fahrzeug registriert wird
     */
    private static void registerVehicleInteractive(Garage garage) {
        System.out.println("Welchen Fahrzeug-Typ möchten Sie registrieren?");
        System.out.println("1) Car");
        System.out.println("2) Truck");
        System.out.println("3) Motorcycle");
        System.out.print("Auswahl: ");
        int type = readInt();

        scanner.nextLine();

        System.out.print("Kennzeichen: ");
        String plate = scanner.nextLine();

        System.out.print("Basis-Kosten der Reparatur (z.B. 500): ");
        double baseCost = readDouble();

        switch (type) {
            case 1 -> {
                System.out.print("Anzahl Türen: ");
                int doors = readInt();
                Vehicle car = new Car(plate, baseCost, doors);
                garage.registerVehicle(car);
                System.out.println("Car registriert: " + car);
            }
            case 2 -> {
                System.out.print("Ladekapazität in Tonnen (z.B. 12.5): ");
                double tons = readDouble();
                Vehicle truck = new Truck(plate, baseCost, tons);
                garage.registerVehicle(truck);
                System.out.println("Truck registriert: " + truck);
            }
            case 3 -> {
                System.out.print("Hat das Motorrad einen Seitenwagen? (true/false): ");
                boolean hasSidecar = readBoolean();
                Vehicle moto = new Motorcycle(plate, baseCost, hasSidecar);
                garage.registerVehicle(moto);
                System.out.println("Motorcycle registriert: " + moto);
            }
            default -> System.out.println("Unbekannter Typ!");
        }
    }

    /**
     * Liest eine ganze Zahl von der Konsole ein.
     * Stellt sicher, dass nur gültige Integer-Werte akzeptiert werden.
     *
     * @return die eingelesene ganze Zahl
     */
    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Bitte eine ganze Zahl eingeben: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Liest eine Gleitkommazahl von der Konsole ein.
     * Stellt sicher, dass nur gültige Zahlen akzeptiert werden.
     *
     * @return die eingelesene Zahl
     */
    private static double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Bitte eine Zahl (z.B. 500 oder 12.5) eingeben: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Liest einen boolean-Wert von der Konsole ein.
     * Es werden nur die Werte {@code true} oder {@code false} akzeptiert.
     *
     * @return der eingelesene Wahrheitswert
     */
    private static boolean readBoolean() {
        while (!scanner.hasNextBoolean()) {
            System.out.print("Bitte 'true' oder 'false' eingeben: ");
            scanner.next();
        }
        return scanner.nextBoolean();
    }
}
