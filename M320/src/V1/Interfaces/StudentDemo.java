package V1.Interfaces;

public class StudentDemo {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();
        group.add(new Student("Benji", 5));
        group.add(new Student("Eric", 4));
        group.add(new Student("Dom", 6));

        System.out.println("Alle Studierenden:");
        for (Student s : group) {
            System.out.println(" - " + s);
        }

        System.out.println("\nSortiert nach Note (beste zuerst):");
        for (Student s : group.getStudentsSortedByGrade()) {
            System.out.println(" - " + s);
        }

        System.out.println("\nBester Student:");
        System.out.println(" -> " + group.getBestStudent());
    }
}
