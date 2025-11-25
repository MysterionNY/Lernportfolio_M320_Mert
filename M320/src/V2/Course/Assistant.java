package V2.Course;

public class Assistant extends Person {

    public Assistant(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "Assistent";
    }
}
