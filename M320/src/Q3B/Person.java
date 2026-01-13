package Q3B;

public class Person {
    private String name;
    private boolean hasCar;

    public Person(String name) {
        this.name = name;
        this.hasCar = false;
    }

    public String getName() {
        return name;
    }

    public boolean hasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    @Override
    public String toString() {
        return name;
    }
}

