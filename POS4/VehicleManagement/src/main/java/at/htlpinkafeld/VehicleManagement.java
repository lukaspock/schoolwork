package at.htlpinkafeld;

import java.util.Scanner;

public class VehicleManagement {
    private Vehicle[] vehicles;
    private int count;

    public VehicleManagement(int capacity) {
        vehicles = new Vehicle[capacity];
        this.count = 0;
    }

    public void addVehicle(Vehicle v) {
        if (this.count < this.vehicles.length) {
            this.vehicles[count++] = v;
        } else {
            System.out.println("Vehicle list is full!");
        }
    }

    public void printVehicles() {
        for (int i = 0; i < this.count; i++) {
            this.vehicles[i].print();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleManagement vm = new VehicleManagement(10);

        while (true) {
            System.out.print("Add vehicle (car/bike/exit): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                break;
            }

            System.out.print("Make: ");
            String make = sc.nextLine();
            System.out.print("Model: ");
            String model = sc.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(sc.nextLine());

            switch (choice) {
                case "car" -> {
                    System.out.print("Number of doors: ");
                    int numberOfDoors = Integer.parseInt(sc.nextLine());
                    vm.addVehicle(new Car(make, model, year, price, numberOfDoors));
                }
                case "bike" -> {
                    System.out.print("Kind of bike (RACING/GRAVEL/CROSS/MTB/FULLY): ");
                    String kindStr = sc.nextLine().trim().toUpperCase();

                    Bicycle.KindOfBicycle kindOfBicycle;
                    try {
                        kindOfBicycle = Bicycle.KindOfBicycle.valueOf(kindStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid type, defaulting to RACING.");
                        kindOfBicycle = Bicycle.KindOfBicycle.RACING;
                    }

                    vm.addVehicle(new Bicycle(make, model, year, price, kindOfBicycle));
                }
                default -> System.out.println("Invalid choice!");
            }
        }

        System.out.println("\n--- Vehicle List ---");
        vm.printVehicles();
        sc.close();
    }
}
