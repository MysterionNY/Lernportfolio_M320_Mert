package N1;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotheksverwaltung {
    private static ArrayList<Buch> library = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        library.add(new Buch("Der Alchemist", "Paulo Coelho", 1988));
        library.add(new Buch("1984", "George Orwell", 1949));
        library.add(new Buch("Harry Potter", "J.K. Rowling", 1997));

        boolean beenden = false;

        while (!beenden) {
            zeigeMenu();
            int auswahl = scanner.nextInt();
            scanner.nextLine();

            switch (auswahl) {
                case 1:
                    alleBuecherAnzeigen();
                    break;
                case 2:
                    buchHinzufuegen();
                    break;
                case 3:
                    buchAusleihen();
                    break;
                case 4:
                    buchZurueckgeben();
                    break;
                case 5:
                    beenden = true;
                    System.out.println("Programm wird beendet. Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Ungültige Auswahl!");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void zeigeMenu() {
        System.out.println("=== BIBLIOTHEKSVERWALTUNG ===");
        System.out.println("1. Alle Bücher anzeigen");
        System.out.println("2. Neues Buch hinzufügen");
        System.out.println("3. Buch ausleihen");
        System.out.println("4. Buch zurückgeben");
        System.out.println("5. Beenden");
        System.out.print("Ihre Auswahl: ");
    }

    private static void alleBuecherAnzeigen() {
        System.out.println("\n--- Alle Bücher ---");
        for (int i = 0; i < library.size(); i++) {
            System.out.print((i + 1) + ". ");
            library.get(i).show();
        }
    }

    private static void buchHinzufuegen() {
        System.out.print("\nTitel: ");
        String titel = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Erscheinungsjahr: ");
        int jahr = scanner.nextInt();
        scanner.nextLine();

        library.add(new Buch(titel, autor, jahr));
        System.out.println("Buch erfolgreich hinzugefügt!");
    }

    private static void buchAusleihen() {
        alleBuecherAnzeigen();
        System.out.print("\nWelches Buch möchten Sie ausleihen? (Nummer): ");
        int nummer = scanner.nextInt();
        scanner.nextLine();

        if (nummer > 0 && nummer <= library.size()) {
            Buch buch = library.get(nummer - 1);
            if (buch.lending()) {
                System.out.println("Buch erfolgreich ausgeliehen!");
            } else {
                System.out.println("Buch ist bereits ausgeliehen!");
            }
        } else {
            System.out.println("Ungültige Nummer!");
        }
    }

    private static void buchZurueckgeben() {
        alleBuecherAnzeigen();
        System.out.print("\nWelches Buch möchten Sie zurückgeben? (Nummer): ");
        int nummer = scanner.nextInt();
        scanner.nextLine();

        if (nummer > 0 && nummer <= library.size()) {
            Buch buch = library.get(nummer - 1);
            if (buch.zurueckgeben()) {
                System.out.println("Buch erfolgreich zurückgegeben!");
            } else {
                System.out.println("Buch war nicht ausgeliehen!");
            }
        } else {
            System.out.println("Ungültige Nummer!");
        }
    }
}