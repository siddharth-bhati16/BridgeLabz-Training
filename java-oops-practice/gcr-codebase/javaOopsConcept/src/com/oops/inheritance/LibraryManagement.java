package com.oops.inheritance;

//Superclass
class Book {
 String title;
 int publicationYear;

 // Constructor
 Book(String title, int publicationYear) {
     this.title = title;
     this.publicationYear = publicationYear;
 }

 // Method to display book info
 void displayInfo() {
     System.out.println("Book Title: " + title);
     System.out.println("Publication Year: " + publicationYear);
 }
}

//Subclass (extends Book)
class Author extends Book {
 String name;
 String bio;

 // Constructor
 Author(String title, int publicationYear, String name, String bio) {
     super(title, publicationYear); // Call superclass constructor
     this.name = name;
     this.bio = bio;
 }

 // Overriding displayInfo method
 @Override
 void displayInfo() {
     super.displayInfo(); // Display book details
     System.out.println("Author Name: " + name);
     System.out.println("Author Bio: " + bio);
 }
}

//Main class
public class LibraryManagement {
 public static void main(String[] args) {
     Author bookWithAuthor = new Author(
         "The Great Adventure",
         2023,
         "Alex Johnson",
         "An award-winning fiction writer."
     );

     bookWithAuthor.displayInfo();
 }
}
