package com.oops.objectmodeling.levelone;

import java.util.ArrayList;

//Book class (independent)
class Book {
 private String title;
 private String author;

 public Book(String title, String author) {
     this.title = title;
     this.author = author;
 }

 public void displayBook() {
     System.out.println("Title: " + title + ", Author: " + author);
 }
}

//Library class (aggregates Book objects)
class Library {
 private String name;
 private ArrayList<Book> books;

 public Library(String name) {
     this.name = name;
     books = new ArrayList<>();
 }

 public void addBook(Book book) {
     books.add(book);
 }

 public void showBooks() {
     System.out.println("Library: " + name);
     for (Book book : books) {
         book.displayBook();
     }
     System.out.println();
 }
}

//Main class
public class LibraryBooks {
 public static void main(String[] args) {

     // Books exist independently
     Book b1 = new Book("Java Programming", "James Gosling");
     Book b2 = new Book("Clean Code", "Robert C. Martin");
     Book b3 = new Book("Python Basics", "Guido van Rossum");

     // Libraries
     Library cityLibrary = new Library("City Library");
     Library collegeLibrary = new Library("College Library");

     // Adding books to libraries
     cityLibrary.addBook(b1);
     cityLibrary.addBook(b2);

     collegeLibrary.addBook(b2); // same book in another library
     collegeLibrary.addBook(b3);

     // Display books
     cityLibrary.showBooks();
     collegeLibrary.showBooks();
 }
}
