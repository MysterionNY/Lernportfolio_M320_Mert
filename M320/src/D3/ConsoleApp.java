package D3;

import java.util.Scanner;

public class ConsoleApp {

    private final MovieController controller;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleApp(MovieController controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.println("=== MovieFinder ===");

        try {
            System.out.print("Filmtitel: ");
            String title = scanner.nextLine();

            System.out.print("Erscheinungsjahr (optional, Enter für leer): ");
            String yearInput = scanner.nextLine();

            String result = controller.searchMovie(title, yearInput);
            System.out.println();
            System.out.println(result);

        } catch (InvalidUserInputException e) {
            System.out.println("Eingabefehler: " + e.getMessage());
        } catch (MovieNotFoundException e) {
            System.out.println("Fehler: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unerwarteter Fehler: " + e.getMessage());
        }
    }
}
