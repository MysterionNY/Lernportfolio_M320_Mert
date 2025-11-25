package V2.Course;

public class Teacher extends Person {

    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public String getRole() {
        return "Lehrperson";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (Fach: " + subject + ")";
    }
}
