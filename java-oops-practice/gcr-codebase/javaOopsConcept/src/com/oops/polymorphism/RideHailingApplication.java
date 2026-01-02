package com.oops.polymorphism;

import java.util.*;

//Interface
interface GPS {
 String getCurrentLocation();
 void updateLocation(String location);
}

//Abstract class
abstract class Vehicle {
 // Encapsulation: private fields
 private int vehicleId;
 private String driverName;
 protected double ratePerKm;
 private String location;

 // Constructor
 public Vehicle(int vehicleId, String driverName, double ratePerKm) {
     this.vehicleId = vehicleId;
     this.driverName = driverName;
     this.ratePerKm = ratePerKm;
 }

 // Abstract method
 public abstract double calculateFare(double distance);

 // Concrete method
 public void getVehicleDetails() {
     System.out.println("Vehicle ID: " + vehicleId);
     System.out.println("Driver Name: " + driverName);
     System.out.println("Rate per Km: " + ratePerKm);
     System.out.println("Location: " + location);
 }

 // Protected GPS helpers
 protected void setLocation(String location) {
     this.location = location;
 }

 protected String getLocation() {
     return location;
 }
}

//Car class
class Car extends Vehicle implements GPS {

 public Car(int id, String driver, double rate) {
     super(id, driver, rate);
 }

 public double calculateFare(double distance) {
     return ratePerKm * distance + 50; // base charge
 }

 public String getCurrentLocation() {
     return getLocation();
 }

 public void updateLocation(String location) {
     setLocation(location);
 }
}

//Bike class
class Bike extends Vehicle implements GPS {

 public Bike(int id, String driver, double rate) {
     super(id, driver, rate);
 }

 public double calculateFare(double distance) {
     return ratePerKm * distance; // no extra charge
 }

 public String getCurrentLocation() {
     return getLocation();
 }

 public void updateLocation(String location) {
     setLocation(location);
 }
}

//Auto class
class Auto extends Vehicle implements GPS {

 public Auto(int id, String driver, double rate) {
     super(id, driver, rate);
 }

 public double calculateFare(double distance) {
     return ratePerKm * distance + 20; // small base charge
 }

 public String getCurrentLocation() {
     return getLocation();
 }

 public void updateLocation(String location) {
     setLocation(location);
 }
}

//Main class
public class RideHailingApplication {

 // Polymorphic method
 public static void calculateRideFare(List<Vehicle> vehicles, double distance) {

     for (Vehicle v : vehicles) {
         v.getVehicleDetails();
         System.out.println("Distance: " + distance + " km");
         System.out.println("Total Fare: " + v.calculateFare(distance));
         System.out.println("-------------------------");
     }
 }

 public static void main(String[] args) {

     List<Vehicle> vehicles = new ArrayList<>();

     Vehicle v1 = new Car(1, "Alice", 15);
     Vehicle v2 = new Bike(2, "Bob", 8);
     Vehicle v3 = new Auto(3, "Charlie", 10);

     ((GPS) v1).updateLocation("Downtown");
     ((GPS) v2).updateLocation("City Center");
     ((GPS) v3).updateLocation("Railway Station");

     vehicles.add(v1);
     vehicles.add(v2);
     vehicles.add(v3);

     // Polymorphism in action
     calculateRideFare(vehicles, 10);
 }
}

