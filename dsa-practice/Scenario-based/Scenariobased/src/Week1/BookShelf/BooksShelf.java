package Week1.BookShelf;

import java.util.*;

class Book {
 String title;
 String author;

 public Book(String title, String author) {
     this.title = title;
     this.author = author;
 }

 @Override
 public String toString() {
     return "\"" + title + "\" by " + author;
 }

 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (obj == null || getClass() != obj.getClass()) return false;
     Book book = (Book) obj;
     return Objects.equals(title, book.title) && Objects.equals(author, book.author);
 }

 @Override
 public int hashCode() {
     return Objects.hash(title, author);
 }
}

//Library Organizer class
class BookShelf {
 // Map genre → LinkedList of books
 private Map<String, LinkedList<Book>> library;
 // Optional HashSet to avoid duplicates
 private Map<String, Set<Book>> duplicateChecker;

 public BookShelf() {
     library = new HashMap<>();
     duplicateChecker = new HashMap<>();
 }

 // Add a book to a genre
 public void addBook(String genre, Book book) {
     library.putIfAbsent(genre, new LinkedList<>());
     duplicateChecker.putIfAbsent(genre, new HashSet<>());

     if (duplicateChecker.get(genre).contains(book)) {
         System.out.println(book + " already exists in " + genre);
         return;
     }

     library.get(genre).add(book);
     duplicateChecker.get(genre).add(book);
     System.out.println(book + " added to " + genre);
 }

 // Remove a book from a genre
 public void removeBook(String genre, Book book) {
     if (!library.containsKey(genre) || !library.get(genre).contains(book)) {
         System.out.println(book + " not found in " + genre);
         return;
     }

     library.get(genre).remove(book);
     duplicateChecker.get(genre).remove(book);
     System.out.println(book + " removed from " + genre);
 }

 // Display all books genre-wise
 public void displayLibrary() {
     System.out.println("\nLibrary Catalog:");
     for (String genre : library.keySet()) {
         System.out.println("Genre: " + genre);
         LinkedList<Book> books = library.get(genre);
         if (books.isEmpty()) {
             System.out.println("  No books available");
         } else {
             for (Book book : books) {
                 System.out.println("  - " + book);
             }
         }
     }
 }
}

//Demos
public class BooksShelf {
 public static void main(String[] args) {
     BookShelf shelf = new BookShelf();

     Book book1 = new Book("The Hobbit", "J.R.R. Tolkien");
     Book book2 = new Book("1984", "George Orwell");
     Book book3 = new Book("The Silmarillion", "J.R.R. Tolkien");
     Book book4 = new Book("The Hobbit", "J.R.R. Tolkien"); // duplicate

     shelf.addBook("Fantasy", book1);
     shelf.addBook("Dystopian", book2);
     shelf.addBook("Fantasy", book3);
     shelf.addBook("Fantasy", book4); // will be detected as duplicate

     shelf.displayLibrary();

     shelf.removeBook("Fantasy", book1);
     shelf.displayLibrary();
 }
}

