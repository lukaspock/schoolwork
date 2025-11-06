package at.htlpinkafeld;

public class Car implements Size{
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
}
