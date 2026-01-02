package com.oops.polymorphism;

import java.util.*;

//Interface
interface Taxable {
 double calculateTax();
 String getTaxDetails();
}

//Abstract class
abstract class Product {
 // Encapsulation: private fields
 private int productId;
 private String name;
 protected double price;

 // Constructor
 public Product(int productId, String name, double price) {
     this.productId = productId;
     this.name = name;
     this.price = price;
 }

 // Getters and setters
 public int getProductId() {
     return productId;
 }

 public String getName() {
     return name;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 // Abstract method
 public abstract double calculateDiscount();

 // Concrete method
 public void displayProduct() {
     System.out.println("ID: " + productId);
     System.out.println("Name: " + name);
     System.out.println("Base Price: " + price);
 }
}

//Electronics class
class Electronics extends Product implements Taxable {

 public Electronics(int id, String name, double price) {
     super(id, name, price);
 }

 public double calculateDiscount() {
     return price * 0.10; // 10% discount
 }

 public double calculateTax() {
     return price * 0.18; // 18% tax
 }

 public String getTaxDetails() {
     return "Electronics Tax: 18%";
 }
}

//Clothing class
class Clothing extends Product implements Taxable {

 public Clothing(int id, String name, double price) {
     super(id, name, price);
 }

 public double calculateDiscount() {
     return price * 0.20; // 20% discount
 }

 public double calculateTax() {
     return price * 0.12; // 12% tax
 }

 public String getTaxDetails() {
     return "Clothing Tax: 12%";
 }
}

//Groceries class (No tax)
class Groceries extends Product {

 public Groceries(int id, String name, double price) {
     super(id, name, price);
 }

 public double calculateDiscount() {
     return price * 0.05; // 5% discount
 }
}

//Main class
public class ECommercePlatform {

 // Polymorphic method
 public static void printFinalPrice(List<Product> products) {

     for (Product p : products) {
         double tax = 0;

         if (p instanceof Taxable) {
             tax = ((Taxable) p).calculateTax();
         }

         double discount = p.calculateDiscount();
         double finalPrice = p.price + tax - discount;

         p.displayProduct();
         System.out.println("Discount: " + discount);
         System.out.println("Tax: " + tax);
         System.out.println("Final Price: " + finalPrice);
         System.out.println("-------------------------");
     }
 }

 public static void main(String[] args) {

     List<Product> products = new ArrayList<>();

     products.add(new Electronics(1, "Laptop", 60000));
     products.add(new Clothing(2, "Jacket", 3000));
     products.add(new Groceries(3, "Rice", 1000));

     // Polymorphism in action
     printFinalPrice(products);
 }
}

