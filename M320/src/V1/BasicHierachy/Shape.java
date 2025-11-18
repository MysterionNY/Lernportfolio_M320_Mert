package V1.BasicHierachy;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();

    public double getPerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return name + " mit Fläche: " + getArea();
    }
}
