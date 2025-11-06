package at.htlpinkafeld;

public class Bicycle extends Vehicle {
    public enum KindOfBicycle {
        RACING, GRAVEL, CROSS, MTB, FULLY
    }

    private KindOfBicycle kindOfBike;

    public Bicycle(String make, String model, int yearOfManufacture, double price, KindOfBicycle kindOfBicycle) {
        super(make, model, yearOfManufacture, price);
        this.kindOfBike = kindOfBicycle;
    }

    @Override
    public double calculateTax() {
        double taxRate = switch (this.kindOfBike) {
            case RACING -> 1.0;
            case GRAVEL -> 1.5;
            case CROSS -> 2.0;
            case MTB -> 2.5;
            case FULLY -> 3.0;
        };
        return taxRate * this.price;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Kind of bike: " + this.kindOfBike);
    }
}
