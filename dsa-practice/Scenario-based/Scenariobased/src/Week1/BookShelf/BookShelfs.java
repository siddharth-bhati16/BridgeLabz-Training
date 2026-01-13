package Week1.BookShelf;

import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return title.equalsIgnoreCase(book.title) &&
               author.equalsIgnoreCase(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase());
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

public class BookShelfs {

    private Map<String, LinkedList<Book>> genreMap = new HashMap<>();
    private Set<Book> bookSet = new HashSet<>(); 

    public void addBook(String genre, String title, String author) {
        Book book = new Book(title, author);

        if (bookSet.contains(book)) {
            System.out.println("Duplicate book ignored: " + book);
            return;
        }

        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreMap.get(genre).add(book);
        bookSet.add(book);

        System.out.println("Book added: " + book + " [Genre: " + genre + "]");
    }

    public void removeBook(String genre, String title, String author) {
        Book book = new Book(title, author);

        LinkedList<Book> list = genreMap.get(genre);
        if (list == null || !list.remove(book)) {
            System.out.println("Book not found.");
            return;
        }

        bookSet.remove(book);
        System.out.println("Book borrowed: " + book);

        if (list.isEmpty()) {
            genreMap.remove(genre);
        }
    }

    public void displayCatalog() {
        if (genreMap.isEmpty()) {
            System.out.println("Library catalog is empty.");
            return;
        }

        for (String genre : genreMap.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : genreMap.get(genre)) {
                System.out.println("  - " + book);
            }
        }
    }

    public static void main(String[] args) {
        BookShelfs library = new BookShelfs();

        library.addBook("Fiction", "1984", "George Orwell");
        library.addBook("Fiction", "Animal Farm", "George Orwell");
        library.addBook("Science", "A Brief History of Time", "Stephen Hawking");
        library.addBook("Fiction", "1984", "George Orwell"); // duplicate

        library.displayCatalog();

        library.removeBook("Fiction", "1984", "George Orwell");
        library.displayCatalog();
    }
}

