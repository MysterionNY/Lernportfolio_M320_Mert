package V2.Course;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    public abstract String getRole();

    public String getDescription() {
        return getRole() + ": " + name;
    }
}

