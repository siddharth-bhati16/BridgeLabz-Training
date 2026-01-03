package com.oops.scenariobased;

interface Rentable {
    double calculateRent(int days);
}

// Base Class
class Vehicle implements Rentable {
    protected String vehicleId;
    protected String brand;
    protected double baseRate;

    // Constructor
    public Vehicle(String vehicleId, String brand, double baseRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    // Encapsulation using getters/setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public double getBaseRate() {
        return baseRate;
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days;
    }
}

// Bike Class
class Bike extends Vehicle {

    public Bike(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        // No extra charges
        return baseRate * days;
    }
}

// Car Class
class Car extends Vehicle {
    private double insuranceFee = 200;

    public Car(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate * days) + insuranceFee;
    }
}

// Truck Class
class Truck extends Vehicle {
    private double loadCharge = 500;

    public Truck(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate * days) + loadCharge;
    }
}

// Customer Class
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void rentVehicle(Vehicle vehicle, int days) {
        System.out.println(name + " rented " + vehicle.getBrand());
        System.out.println("Total Rent for " + days + " days: ₹" +
                vehicle.calculateRent(days));
        System.out.println("-----------------------------");
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {

        Customer customer = new Customer("Rahul");

        Vehicle bike = new Bike("B101", "Yamaha", 300);
        Vehicle car = new Car("C201", "Honda", 1200);
        Vehicle truck = new Truck("T301", "Tata", 2000);

        // Polymorphism in action
        customer.rentVehicle(bike, 3);
        customer.rentVehicle(car, 3);
        customer.rentVehicle(truck, 3);
    }
}
