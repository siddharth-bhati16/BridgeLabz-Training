package com.oops.scenariobased;

import java.util.*;

interface IDiscountable {
 double applyDiscount(int quantity);
}

abstract class Book implements IDiscountable {
 protected String title;
 protected String author;
 protected double price;
 
 private int stock; 

 public Book(String title, String author, double price, int stock) {
     this.title = title;
     this.author = author;
     this.price = price;
     this.stock = stock;
 }

 public Book(String title, String author, double price, int stock, double offerPrice) {
     this.title = title;
     this.author = author;
     this.price = offerPrice;
     this.stock = stock;
 }

 public boolean reduceStock(int quantity) {
     if (quantity <= stock) {
         stock -= quantity;
         return true;
     }
     return false;
 }

 public int getStock() {
     return stock;
 }

 public double getPrice() {
     return price;
 }
}

class EBook extends Book {

 public EBook(String title, String author, double price, int stock) {
     super(title, author, price, stock);
 }

 @Override
 public double applyDiscount(int quantity) {
     return price * quantity * 0.10;
 }
}

class PrintedBook extends Book {

 public PrintedBook(String title, String author, double price, int stock) {
     super(title, author, price, stock);
 }

 @Override
 public double applyDiscount(int quantity) {
     if (quantity >= 2) {
         return price * quantity * 0.05;
     }
     return 0;
 }
}

class Order {
 private String userName;
 private Map<Book, Integer> items = new HashMap<>();
 private String status = "CREATED"; 
 public Order(String userName) {
     this.userName = userName;
 }

 public void addBook(Book book, int quantity) {
     if (book.reduceStock(quantity)) {
         items.put(book, quantity);
     } else {
         System.out.println("Insufficient stock for book.");
     }
 }

 public double calculateTotalCost() {
     double total = 0;

     for (Map.Entry<Book, Integer> entry : items.entrySet()) {
         Book book = entry.getKey();
         int quantity = entry.getValue();

         double discount = book.applyDiscount(quantity);
         total += (book.getPrice() * quantity) - discount;
     }
     return total;
 }

 protected void updateStatus(String newStatus) {
     this.status = newStatus;
 }

 public String getStatus() {
     return status;
 }
}

public class BookBaazar {

 public static void main(String[] args) {

     Book ebook = new EBook("Java Basics", "James Gosling", 500, 50);
     Book printedBook = new PrintedBook("Clean Code", "Robert C. Martin", 800, 20);

     Order order = new Order("Anita");

     order.addBook(ebook, 2);
     order.addBook(printedBook, 3);

     System.out.println("Order Status: " + order.getStatus());
     System.out.println("Total Cost: ₹" + order.calculateTotalCost());

     // Internal status update
     order.updateStatus("CONFIRMED");
     System.out.println("Updated Order Status: " + order.getStatus());
 }
}

