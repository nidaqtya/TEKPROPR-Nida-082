public class Shape {
    private String color;
    private boolean filled;

    // Constructor default
    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    // Constructor dengan parameter
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter & Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of " + color +
               " and " + (filled ? "filled" : "Not filled");
    }
}