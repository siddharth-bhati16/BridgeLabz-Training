package Sortings;

class SmartShelf {

    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        void display() {
            System.out.println(title + " by " + author);
        }
    }

    static void insertionSort(Book[] books, int n) {
        for (int i = 1; i < n; i++) {
            Book key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].title.compareToIgnoreCase(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    static void displayShelf(Book[] books, int n) {
        System.out.println("Books on SmartShelf:");
        for (int i = 0; i < n; i++) {
            books[i].display();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Book[] shelf = new Book[10]; 
        int count = 0;

        shelf[count++] = new Book("The Alchemist", "Paulo Coelho");
        shelf[count++] = new Book("Harry Potter", "J.K. Rowling");
        shelf[count++] = new Book("Animal Farm", "George Orwell");
        shelf[count++] = new Book("Brave New World", "Aldous Huxley");

        System.out.println("Before Sorting:");
        displayShelf(shelf, count);

        insertionSort(shelf, count);

        System.out.println("After Sorting:");
        displayShelf(shelf, count);

        shelf[count++] = new Book("Catch-22", "Joseph Heller");
        insertionSort(shelf, count); 
        System.out.println("After Adding New Book:");
        displayShelf(shelf, count);
    }
}

