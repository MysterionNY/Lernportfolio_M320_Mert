package V1.BasicHierachy;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape r = new Rectangle(3, 4);
        Shape c = new Circle(2.5);

        System.out.println(r);
        System.out.println("Umfang Rechteck: " + r.getPerimeter());

        System.out.println(c);
        System.out.println("Umfang Kreis: " + c.getPerimeter());
    }
}
