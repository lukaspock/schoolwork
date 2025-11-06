package at.htlpinkafeld;
import java.util.Objects;

public class Car implements Size, Comparable{
    private String brand;    //Marke
    private int releaseDate; //Year
    private int maxPower;
    private int length;
    private int width;
    private int height;

    public Car(String brand, int releaseDate, int maxPower, int length, int width, int height) {
        this.brand = brand;
        this.releaseDate = releaseDate;
        this.maxPower = maxPower;
        this.length = length;
        this.width = width;
        this.height = height;

    }

    @Override
    public int getLength() {
        return length;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Car) {
            Car help = (Car) o;

            if (Main.calcArea(this) == Main.calcArea(help)) {
                return 0;
            }
            if (Main.calcArea(this) > Main.calcArea(help)) {
                return 1;
            }
            if (Main.calcArea(this) < Main.calcArea(help)) {
                return -1;
            }
        }
        return -2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return releaseDate == car.releaseDate &&
                maxPower == car.maxPower &&
                length == car.length &&
                width == car.width &&
                height == car.height &&
                Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, releaseDate, maxPower, length, width, height);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", releaseDate=" + releaseDate +
                ", maxPower=" + maxPower +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
