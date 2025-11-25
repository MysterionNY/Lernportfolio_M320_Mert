package V2.Course;

public class Student extends Person {

    private int studentNumber;

    public Student(String name, int studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (Matrikel: " + studentNumber + ")";
    }
}
