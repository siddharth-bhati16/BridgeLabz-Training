package com.oops.inheritance;

class Vehicle{
	String maxspeed;
	String Fueltype;
	
	void displayInfo() {
		System.out.println("details of the vehicle");
	}
	
}
class Truck extends Vehicle{
	void displayInfo() {
		System.out.println("details of the truck ");
	}
}
class Car extends Vehicle{
	void displayInfo() {
		System.out.println("details of the car");
	}
}
class Motorcycle extends Vehicle{
	void displayInfo() {
		System.out.println("details of the motorcycle");
	}
}

public class VehicleTransportSystem {
     public static void main(String[] args) {
    	 Truck truck=new Truck();
    	 Car car =new Car();
    	 Motorcycle motorcycle=new Motorcycle();
    	 
    	 truck.displayInfo();
    	 car.displayInfo();
    	 motorcycle.displayInfo();
     }
}
