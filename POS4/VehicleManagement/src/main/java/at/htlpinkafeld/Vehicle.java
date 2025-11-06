package at.htlpinkafeld;

public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int yearOfManufacture;
    protected double price;

    public Vehicle(String make, String model, int yom, double price) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yom;
        this.price = price;
    }

    public abstract double calculateTax();

    public void print() {
        System.out.println("Make: " + make +
                ", Model: " + model +
                ", Year: " + yearOfManufacture +
                ", Price: " + price +
                ", Tax: " + calculateTax());
    }
}
