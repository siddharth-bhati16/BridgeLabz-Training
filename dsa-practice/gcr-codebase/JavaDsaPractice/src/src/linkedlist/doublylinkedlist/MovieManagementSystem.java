package src.linkedlist.doublylinkedlist;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    Movie head, tail;

    /* Add at beginning */
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    /* Add at end */
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    /* Add at specific position (1-based index) */
    void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    /* Remove movie by title */
    void removeByTitle(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title))
            temp = temp.next;

        if (temp == null) {
            System.out.println("Movie not found.");
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

        System.out.println("Movie removed successfully.");
    }

    /* Search by director */
    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director.");
    }

    /* Search by rating */
    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating.");
    }

    /* Update rating by title */
    void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    /* Display forward */
    void displayForward() {
        Movie temp = head;
        System.out.println("\nMovies (Forward Order):");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    /* Display reverse */
    void displayReverse() {
        Movie temp = tail;
        System.out.println("\nMovies (Reverse Order):");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    void displayMovie(Movie m) {
        System.out.println(
            m.title + " | " +
            m.director + " | " +
            m.year + " | Rating: " +
            m.rating
        );
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        list.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtEnd("Titanic", "James Cameron", 1997, 7.9);
        list.addAtPosition(2, "Avatar", "James Cameron", 2009, 7.8);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Christopher Nolan");
        list.updateRating("Titanic", 8.0);
        list.removeByTitle("Avatar");

        list.displayForward();
    }
}

