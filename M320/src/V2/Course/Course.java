package V2.Course;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String title;
    private Teacher teacher;
    private Assistant assistant;
    private List<Student> students = new ArrayList<>();
    private int minStudents;
    private int maxStudents;

    public Course(String title, Teacher teacher, Assistant assistant,
                  int minStudents, int maxStudents) {
        this.title = title;
        this.teacher = teacher;
        this.assistant = assistant;
        this.minStudents = minStudents;
        this.maxStudents = maxStudents;
    }

    public void enrollStudent(Student s) {
        if (students.size() >= maxStudents) {
            System.out.println("Kurs ist voll, kann " + s.getDescription() + " nicht anmelden.");
            return;
        }
        students.add(s);
    }

    public void enrollStudent(String name, int studentNumber) {
        enrollStudent(new Student(name, studentNumber));
    }

    public boolean canStart() {
        return students.size() >= minStudents;
    }

    public void printParticipants() {
        System.out.println("====================================");
        System.out.println("Kurs: " + title);
        System.out.println("Lehrperson: " + teacher.getDescription());
        System.out.println("Assistent:  " + assistant.getDescription());
        System.out.println("------------------------------------");
        System.out.println("Teilnehmende:");
        if (students.isEmpty()) {
            System.out.println(" (noch keine Studierenden angemeldet)");
        } else {
            for (Student s : students) {
                System.out.println(" - " + s.getDescription());
            }
        }
        System.out.println("------------------------------------");
        System.out.println("Anzahl Studierende: " + students.size());
        System.out.println("Min.: " + minStudents + ", Max.: " + maxStudents);
        System.out.println("Kann Kurs starten? " + (canStart() ? "JA" : "NEIN"));
        System.out.println("====================================");
    }
}

