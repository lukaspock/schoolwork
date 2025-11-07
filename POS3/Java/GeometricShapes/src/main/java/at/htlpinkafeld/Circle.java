package at.htlpinkafeld;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.round((Math.PI * radius * radius) * 100) / 100.0;
    }

    @Override
    public String toString() {
        return "Circle, area=" + this.getArea() + ", Parameters: radius=" + radius;
    }
}
