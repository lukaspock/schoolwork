package at.htlpinkafeld;

public class Car extends Vehicle {
    private int numberDoors;

    public Car(String make, String model, int yom, double price, int numberDoors) {
        super(make, model, yom, price);
        this.numberDoors = numberDoors;
    }

    @Override
    public double calculateTax() {
        return 20 * this.numberDoors;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Number of doors: " + this.numberDoors);
    }
}
