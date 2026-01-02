package com.oops.polymorphism;
import java.util.*;

//Interface
interface Insurable {
 double calculateInsurance();
 String getInsuranceDetails();
}

//Abstract class
abstract class Vehicle {
 // Encapsulation: private fields
 private String vehicleNumber;
 private String type;
 protected double rentalRate;

 // Constructor
 public Vehicle(String vehicleNumber, String type, double rentalRate) {
     this.vehicleNumber = vehicleNumber;
     this.type = type;
     this.rentalRate = rentalRate;
 }

 // Getter
 public String getVehicleNumber() {
     return vehicleNumber;
 }

 public String getType() {
     return type;
 }

 // Abstract method
 public abstract double calculateRentalCost(int days);

 // Concrete method
 public void displayDetails() {
     System.out.println("Vehicle No: " + vehicleNumber);
     System.out.println("Type: " + type);
     System.out.println("Rental Rate per day: " + rentalRate);
 }
}

//Car class
class Car extends Vehicle implements Insurable {
 private String insurancePolicyNo; // sensitive data

 public Car(String number, double rate, String policyNo) {
     super(number, "Car", rate);
     this.insurancePolicyNo = policyNo;
 }

 public double calculateRentalCost(int days) {
     return rentalRate * days;
 }

 public double calculateInsurance() {
     return 500; // fixed insurance
 }

 public String getInsuranceDetails() {
     return "Car Insurance Applied";
 }
}

//Bike class
class Bike extends Vehicle implements Insurable {
 private String insurancePolicyNo;

 public Bike(String number, double rate, String policyNo) {
     super(number, "Bike", rate);
     this.insurancePolicyNo = policyNo;
 }

 public double calculateRentalCost(int days) {
     return rentalRate * days;
 }

 public double calculateInsurance() {
     return 200;
 }

 public String getInsuranceDetails() {
     return "Bike Insurance Applied";
 }
}

//Truck class
class Truck extends Vehicle implements Insurable {
 private String insurancePolicyNo;

 public Truck(String number, double rate, String policyNo) {
     super(number, "Truck", rate);
     this.insurancePolicyNo = policyNo;
 }

 public double calculateRentalCost(int days) {
     return rentalRate * days + 1000; // extra charge
 }

 public double calculateInsurance() {
     return 1000;
 }

 public String getInsuranceDetails() {
     return "Truck Insurance Applied";
 }
}

//Main class
public class RentalVehicle {
 public static void main(String[] args) {

     List<Vehicle> vehicles = new ArrayList<>();

     vehicles.add(new Car("CAR101", 2000, "C123"));
     vehicles.add(new Bike("BIKE202", 500, "B456"));
     vehicles.add(new Truck("TRUCK303", 4000, "T789"));

     int days = 3;

     // Polymorphism
     for (Vehicle v : vehicles) {
         v.displayDetails();

         double rentalCost = v.calculateRentalCost(days);
         double insurance = ((Insurable) v).calculateInsurance();

         System.out.println("Rental Cost for " + days + " days: " + rentalCost);
         System.out.println("Insurance Cost: " + insurance);
         System.out.println(((Insurable) v).getInsuranceDetails());
         System.out.println("------------------------");
     }
 }
}
