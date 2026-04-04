public class Cylinder extends Circle {
    private double height; // private variable 
    
    // Constructor with deafult color, radius, adn height
    public Cylinder() {
        super(); // call superclass np-arg constructor Circle()
        this.height = 1.0;
    }

    // Constructor height saja
    public Cylinder(double height) {
        super();
        this.height = height;
    }

    // Constructor with default color, but given radius and height
    public Cylinder(double radius, double height) {
        super(radius); // call superclass 1-arg constructor Circle(radius)
        this.height = height;
    }

    // Constructor lengkap
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    // A public method for computing the volume of this cylinder
    // use superclass method getArea() to get the area of the base area
    public double getVolume() {
        return super.getArea() * height; 
        // pakai super supaya aman kalau nanti getArea di-override
    }

        @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * height 
            + 2 * super.getArea();
    }
        @Override
    public String toString() {
        return "Cylinder: subclass of " 
                + super.toString()
                + ", height=" + height;
    }
}

