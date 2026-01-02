package com.oops.inheritance;

//Superclass
class Device {
 String deviceId;
 String status;

 // Constructor
 Device(String deviceId, String status) {
     this.deviceId = deviceId;
     this.status = status;
 }

 // Method to display device status
 void displayStatus() {
     System.out.println("Device ID: " + deviceId);
     System.out.println("Status: " + status);
 }
}

//Subclass
class Thermostat extends Device {
 double temperatureSetting;

 // Constructor
 Thermostat(String deviceId, String status, double temperatureSetting) {
     super(deviceId, status); // Call superclass constructor
     this.temperatureSetting = temperatureSetting;
 }

 // Overriding displayStatus method
 @Override
 void displayStatus() {
     super.displayStatus(); // Display general device info
     System.out.println("Temperature Setting: " + temperatureSetting + "°C");
 }
}

//Main class
public class SmartHomeDevices {
 public static void main(String[] args) {
     Thermostat thermostat = new Thermostat(
         "THERMO-101",
         "ON",
         22.5
     );

     thermostat.displayStatus();
 }
}
