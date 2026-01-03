package com.oops.scenariobased;

//Interface (Abstraction)
interface IRideService {
 void bookRide(int distance);
 void endRide();
}

//Vehicle Base Class
class Vehicle {
 protected String vehicleNumber;
 protected int capacity;
 protected double ratePerKm;

 public Vehicle(String vehicleNumber, int capacity, double ratePerKm) {
     this.vehicleNumber = vehicleNumber;
     this.capacity = capacity;
     this.ratePerKm = ratePerKm;
 }
}

//Mini Vehicle
class Mini extends Vehicle {
 public Mini(String vehicleNumber) {
     super(vehicleNumber, 4, 10); // ₹10 per km
 }
}

//Sedan Vehicle
class Sedan extends Vehicle {
 public Sedan(String vehicleNumber) {
     super(vehicleNumber, 4, 15); // ₹15 per km
 }
}

//SUV Vehicle
class SUV extends Vehicle {
 public SUV(String vehicleNumber) {
     super(vehicleNumber, 6, 20); // ₹20 per km
 }
}

//Driver Class
class Driver {
 private String name;
 private String licenseNumber; // sensitive
 private double rating;

 public Driver(String name, String licenseNumber, double rating) {
     this.name = name;
     this.licenseNumber = licenseNumber;
     this.rating = rating;
 }

 public String getName() {
     return name;
 }
}

//Ride Service Class
class RideService implements IRideService {
 private Vehicle vehicle;
 private Driver driver;
 private double fare; // encapsulated
 private final double baseFare = 50;

 public RideService(Vehicle vehicle, Driver driver) {
     this.vehicle = vehicle;
     this.driver = driver;
 }

 @Override
 public void bookRide(int distance) {
     fare = baseFare + (distance * vehicle.ratePerKm); // operator usage
     System.out.println("Ride booked with " + driver.getName());
     System.out.println("Vehicle No: " + vehicle.vehicleNumber);
     System.out.println("Estimated Fare: ₹" + fare);
 }

 @Override
 public void endRide() {
     System.out.println("Ride ended. Total Fare: ₹" + fare);
 }
}

//Main Class
public class CabbigoRide {
 public static void main(String[] args) {

     Vehicle vehicle = new Sedan("KA01AB1234"); // Polymorphism
     Driver driver = new Driver("Ravi", "DL12345", 4.8);

     IRideService ride = new RideService(vehicle, driver);

     ride.bookRide(10); // 10 km
     ride.endRide();
 }
}
