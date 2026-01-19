package Week2;

import java.util.ArrayList;
import java.util.List;

public class SmartLibrary {

    public static void main(String[] args) {

        List<String> borrowedBooks = new ArrayList<>();
        borrowedBooks.add("Algorithms");
        borrowedBooks.add("Data Structures");
        borrowedBooks.add("Operating Systems");

        System.out.println("Borrowed Books (Before New Issue):");
        printBooks(borrowedBooks);

        String newBook = "Database Systems";
        borrowedBooks.add(newBook);

        insertionSort(borrowedBooks);

        System.out.println("\nBorrowed Books (After New Issue & Auto-Sort):");
        printBooks(borrowedBooks);
    }

    private static void insertionSort(List<String> books) {

        for (int i = 1; i < books.size(); i++) {

            String key = books.get(i);
            int j = i - 1;

            while (j >= 0 && books.get(j).compareToIgnoreCase(key) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }

            books.set(j + 1, key);
        }
    }

    private static void printBooks(List<String> books) {
        for (String book : books) {
            System.out.println(book);
        }
    }
}
