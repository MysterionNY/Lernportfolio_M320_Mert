package V2.Course;

import java.util.Scanner;

public class CourseApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Course course = createDefaultCourse();
        boolean running = true;

        while (running) {
            System.out.println("====================================");
            System.out.println("         KURS-ANMELDE-TOOL          ");
            System.out.println("====================================");
            System.out.println("1) Kurs-Infos und Teilnehmende anzeigen");
            System.out.println("2) Student anmelden");
            System.out.println("3) Prüfen, ob der Kurs starten kann");
            System.out.println("0) Programm beenden");
            System.out.print("Ihre Auswahl: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> course.printParticipants();
                case 2 -> enrollStudentInteractive(course);
                case 3 -> System.out.println("Kann Kurs starten? " +
                        (course.canStart() ? "JA" : "NEIN"));
                case 0 -> {
                    System.out.println("Programm wird beendet. Auf Wiedersehen!");
                    running = false;
                }
                default -> System.out.println("Ungültige Auswahl!");
            }
        }

        scanner.close();
    }

    private static Course createDefaultCourse() {
        Teacher teacher = new Teacher("Herr Müller", "Java");
        Assistant assistant = new Assistant("Frau Meier");
        return new Course("Java Programmierung 1", teacher, assistant, 2, 30);
    }

    private static void enrollStudentInteractive(Course course) {
        scanner.nextLine();
        System.out.print("Name des Studenten: ");
        String name = scanner.nextLine();

        System.out.print("Matrikelnummer (Zahl): ");
        int number = readInt();

        course.enrollStudent(name, number);
        System.out.println("Student wurde angemeldet.");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Bitte eine ganze Zahl eingeben: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
