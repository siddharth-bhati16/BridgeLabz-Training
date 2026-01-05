package src.linkedlist.circularlinkedlist;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private int size = 0;

    /* Add a ticket at the end */
    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
        size++;
        System.out.println("Ticket booked successfully.");
    }

    /* Remove ticket by Ticket ID */
    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;
        boolean found = false;

        do {
            if (temp.ticketId == ticketId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Ticket not found.");
            return;
        }

        if (temp == head) {
            // Only one ticket
            if (head.next == head) {
                head = null;
            } else {
                // Update last node to new head
                Ticket last = head;
                while (last.next != head)
                    last = last.next;
                head = head.next;
                last.next = head;
            }
        } else {
            prev.next = temp.next;
        }

        size--;
        System.out.println("Ticket removed successfully.");
    }

    /* Display all tickets */
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("\nCurrent Tickets:");
        Ticket temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    /* Search ticket by customer name */
    void searchByCustomer(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for customer: " + customerName);
    }

    /* Search ticket by movie name */
    void searchByMovie(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for movie: " + movieName);
    }

    /* Count total booked tickets */
    int totalTickets() {
        return size;
    }

    /* Helper: display a single ticket */
    void displayTicket(Ticket t) {
        System.out.println(
            "Ticket ID: " + t.ticketId +
            " | Customer: " + t.customerName +
            " | Movie: " + t.movieName +
            " | Seat: " + t.seatNumber +
            " | Time: " + t.bookingTime
        );
    }
}

public class OnlineTicketSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Sample data
        system.addTicket(101, "ravi ", "dhurandhar", "A1", "10:00AM");
        system.addTicket(102, "keshav", "gopal", "A2", "10:05AM");
        system.addTicket(103, "ravi", "shakti", "B1", "10:10AM");

        system.displayTickets();

        System.out.println("\nSearch tickets by customer :");
        system.searchByCustomer("ravi");

        System.out.println("\nSearch tickets for movie :");
        system.searchByMovie("Avengers");

        System.out.println("\nRemove Ticket ID 102:");
        system.removeTicket(102);

        system.displayTickets();

        System.out.println("\nTotal booked tickets: " + system.totalTickets());
    }
}

