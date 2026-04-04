public class TestShape {
    public static void main(String[] args) {

        // ===== Test Shape =====
        Shape s1 = new Shape();
        System.out.println(s1);
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());

        Shape s2 = new Shape("blue", false);
        System.out.println(s2);
        s2.setColor("red");
        s2.setFilled(true);
        System.out.println("After set: " + s2);
        System.out.println();

        // ===== Test Circle =====
        Circle c1 = new Circle(5.0, "yellow", true);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println();

        // ===== Test Rectangle =====
        Rectangle r1 = new Rectangle(4.0, 6.0, "green", false);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        System.out.println();

        // ===== Test Square =====
        Square sq1 = new Square(4.0, "purple", true);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());

        // Test override setWidth / setLength
        sq1.setWidth(6);
        System.out.println("After setWidth(6): " + sq1);
    }
}