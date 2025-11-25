package V3A;

import java.util.Scanner;

public class PortfolioApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Portfolio portfolio = new Portfolio();
        portfolio.addStock(new Stock("Microsoft", 5));
        portfolio.addStock(new Stock("Apple", 3));
        portfolio.addStock(new Stock("Tesla", 2));

        StockExchange zurich = new ZurichStockExchange();
        StockExchange newYork = new NewYorkStockExchange();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Portfolio Menu ===");
            System.out.println("1) Portfolio anzeigen");
            System.out.println("2) Wert des Portfolios berechnen");
            System.out.println("0) Programm beenden");
            System.out.print("Auswahl: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    portfolio.printStocks();
                    break;
                case 2:
                    // Börse auswählen
                    System.out.println("Börse auswählen:");
                    System.out.println("1) " + zurich.getName());
                    System.out.println("2) " + newYork.getName());
                    System.out.print("Auswahl: ");
                    int exChoice = scanner.nextInt();

                    StockExchange selected;
                    if (exChoice == 1) {
                        selected = zurich;
                    } else {
                        selected = newYork;
                    }

                    double value = portfolio.calculateTotalValue(selected);
                    System.out.println("Wert des Portfolios an der Börse "
                            + selected.getName() + ": " + value);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }

        System.out.println("Programm beendet.");
        scanner.close();
    }
}
