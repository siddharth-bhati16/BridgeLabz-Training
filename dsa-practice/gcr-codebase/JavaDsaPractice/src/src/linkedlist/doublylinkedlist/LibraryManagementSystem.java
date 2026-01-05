package src.linkedlist.doublylinkedlist;

class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean available;
    Book prev, next;

    Book(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.prev = null;
        this.next = null;
    }
}

class LibraryDoublyLinkedList {
    Book head, tail;

    /* Add at beginning */
    void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    /* Add at end */
    void addAtEnd(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    /* Add at specific position (1-based index) */
    void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        Book temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        Book newBook = new Book(id, title, author, genre, available);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    /* Remove by Book ID */
    void removeById(int id) {
        Book temp = head;

        while (temp != null && temp.bookId != id)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head)
            head = temp.next;

        if (temp == tail)
            tail = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;

        System.out.println("Book removed successfully.");
    }

    /* Search by Title */
    void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    /* Search by Author */
    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No books found by this author.");
    }

    /* Update availability */
    void updateAvailability(int id, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    /* Display forward */
    void displayForward() {
        Book temp = head;
        System.out.println("\nLibrary Books (Forward):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    /* Display reverse */
    void displayReverse() {
        Book temp = tail;
        System.out.println("\nLibrary Books (Reverse):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    /* Count books */
    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void displayBook(Book b) {
        System.out.println(
            b.bookId + " | " +
            b.title + " | " +
            b.author + " | " +
            b.genre + " | " +
            (b.available ? "Available" : "Not Available")
        );
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtBeginning(101, "1984", "George Orwell", "Dystopian", true);
        library.addAtEnd(102, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
        library.addAtEnd(103, "The Alchemist", "Paulo Coelho", "Fiction", false);
        library.addAtPosition(2, 104, "Animal Farm", "George Orwell", "Political Satire", true);

        library.displayForward();
        library.displayReverse();

        library.searchByAuthor("George Orwell");
        library.updateAvailability(103, true);
        library.removeById(102);

        library.displayForward();
        System.out.println("\nTotal Books: " + library.countBooks());
    }
}
