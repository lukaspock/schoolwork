package at.htlpinkafeld;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle, area=" + this.getArea() + ", Parameters: width=" + width + ", height=" + height;
    }
}
