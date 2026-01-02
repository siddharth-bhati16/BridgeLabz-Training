package com.oops.polymorphism;

import java.util.*;

//Interface
interface Reservable {
 void reserveItem();
 boolean checkAvailability();
}

//Abstract class
abstract class LibraryItem {
 // Encapsulation: private fields
 private int itemId;
 private String title;
 private String author;
 private String borrowerName; // secured personal data
 protected boolean available = true;

 // Constructor
 public LibraryItem(int itemId, String title, String author) {
     this.itemId = itemId;
     this.title = title;
     this.author = author;
 }

 // Getter (no direct access to borrower details)
 public int getItemId() {
     return itemId;
 }

 // Abstract method
 public abstract int getLoanDuration();

 // Concrete method
 public void getItemDetails() {
     System.out.println("Item ID: " + itemId);
     System.out.println("Title: " + title);
     System.out.println("Author: " + author);
     System.out.println("Available: " + available);
 }

 // Protected method to set borrower
 protected void setBorrower(String name) {
     borrowerName = name;
     available = false;
 }
}

//Book class
class Book extends LibraryItem implements Reservable {

 public Book(int id, String title, String author) {
     super(id, title, author);
 }

 public int getLoanDuration() {
     return 14; // 14 days
 }

 public void reserveItem() {
     if (available) {
         setBorrower("Reserved User");
         System.out.println("Book reserved successfully");
     }
 }

 public boolean checkAvailability() {
     return available;
 }
}

//Magazine class
class Magazine extends LibraryItem implements Reservable {

 public Magazine(int id, String title, String author) {
     super(id, title, author);
 }

 public int getLoanDuration() {
     return 7; // 7 days
 }

 public void reserveItem() {
     if (available) {
         setBorrower("Reserved User");
         System.out.println("Magazine reserved successfully");
     }
 }

 public boolean checkAvailability() {
     return available;
 }
}

//DVD class
class DVD extends LibraryItem implements Reservable {

 public DVD(int id, String title, String author) {
     super(id, title, author);
 }

 public int getLoanDuration() {
     return 3; // 3 days
 }

 public void reserveItem() {
     if (available) {
         setBorrower("Reserved User");
         System.out.println("DVD reserved successfully");
     }
 }

 public boolean checkAvailability() {
     return available;
 }
}

//Main class
public class LibraryManagementSystem {
 public static void main(String[] args) {

     // Polymorphism
     List<LibraryItem> items = new ArrayList<>();

     items.add(new Book(1, "Java Basics", "James Gosling"));
     items.add(new Magazine(2, "Tech Monthly", "Editorial Team"));
     items.add(new DVD(3, "Learning OOP", "Tech Studio"));

     for (LibraryItem item : items) {
         item.getItemDetails();
         System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

         Reservable r = (Reservable) item;
         System.out.println("Available: " + r.checkAvailability());
         r.reserveItem();

         System.out.println("---------------------------");
     }
 }
}

