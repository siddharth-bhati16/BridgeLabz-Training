package com.oops.inheritance;

//Superclass
class Person {
 String name;
 int id;

 // Constructor
 Person(String name, int id) {
     this.name = name;
     this.id = id;
 }

 void displayPersonInfo() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
 }
}

//Interface
interface Worker {
 void performDuties();
}

//Subclass 1
class Chef extends Person implements Worker {

 Chef(String name, int id) {
     super(name, id);
 }

 @Override
 public void performDuties() {
     System.out.println("Role: Chef");
     System.out.println("Duties: Preparing meals and managing the kitchen.");
 }
}

//Subclass 2
class Waiter extends Person implements Worker {

 Waiter(String name, int id) {
     super(name, id);
 }

 @Override
 public void performDuties() {
     System.out.println("Role: Waiter");
     System.out.println("Duties: Serving food and assisting customers.");
 }
}

//Main class
public class RestaurantManagementSystem {
 public static void main(String[] args) {
     Worker chef = new Chef("Rahul", 101);
     Worker waiter = new Waiter("Anita", 102);

     ((Person) chef).displayPersonInfo();
     chef.performDuties();
     System.out.println();

     ((Person) waiter).displayPersonInfo();
     waiter.performDuties();
 }
}
