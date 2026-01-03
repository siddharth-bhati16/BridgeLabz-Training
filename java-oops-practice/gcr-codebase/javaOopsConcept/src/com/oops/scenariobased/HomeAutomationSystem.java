package com.oops.scenariobased;

//Interface (Abstraction)
interface Controllable {
 void turnOn();
 void turnOff();
}

//Base Appliance Class
class Appliance implements Controllable {
 private boolean powerStatus;   // Encapsulation
 private int powerUsage;        // watts

 // Constructor with default power usage
 public Appliance(int powerUsage) {
     this.powerUsage = powerUsage;
     this.powerStatus = false;
 }

 protected int getPowerUsage() {
     return powerUsage;
 }

 public boolean isOn() {
     return powerStatus;
 }

 protected void setPowerStatus(boolean status) {
     this.powerStatus = status;
 }

 @Override
 public void turnOn() {
     powerStatus = true;
     System.out.println("Appliance turned ON");
 }

 @Override
 public void turnOff() {
     powerStatus = false;
     System.out.println("Appliance turned OFF");
 }
}

//Light Class
class Light extends Appliance {

 public Light() {
     super(40); // default power usage
 }

 @Override
 public void turnOn() {
     setPowerStatus(true);
     System.out.println("Light is ON (Soft lighting mode)");
 }
}

//Fan Class
class Fan extends Appliance {

 public Fan(int powerUsage) {
     super(powerUsage);
 }

 @Override
 public void turnOn() {
     setPowerStatus(true);
     System.out.println("Fan is ON (Medium speed)");
 }
}

//AC Class
class AC extends Appliance {

 public AC(int powerUsage) {
     super(powerUsage);
 }

 @Override
 public void turnOn() {
     setPowerStatus(true);
     System.out.println("AC is ON (Cooling at 22°C)");
 }
}

//User Controller Class
class UserController {

 public void operateDevice(Controllable device, boolean turnOn) {
     if (turnOn)
         device.turnOn();
     else
         device.turnOff();
 }

 public void compareEnergy(Appliance a1, Appliance a2) {
     if (a1.getPowerUsage() > a2.getPowerUsage())
         System.out.println("First appliance uses more energy");
     else if (a1.getPowerUsage() < a2.getPowerUsage())
         System.out.println("Second appliance uses more energy");
     else
         System.out.println("Both appliances use equal energy");
 }
}

//Main Class
public class HomeAutomationSystem {
 public static void main(String[] args) {

     Appliance light = new Light();
     Appliance fan = new Fan(75);
     Appliance ac = new AC(1500);

     UserController controller = new UserController();

     // Polymorphism in action
     controller.operateDevice(light, true);
     controller.operateDevice(fan, true);
     controller.operateDevice(ac, true);

     System.out.println();

     // Energy comparison using operators
     controller.compareEnergy(light, ac);

     controller.operateDevice(ac, false);
 }
}
