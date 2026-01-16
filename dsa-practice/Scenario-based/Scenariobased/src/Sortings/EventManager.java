package Sortings;

class EventManager {

    static class Ticket {
        String eventName;
        double price;

        Ticket(String eventName, double price) {
            this.eventName = eventName;
            this.price = price;
        }

        void display() {
            System.out.println(eventName + " | $" + price);
        }
    }

    static void quickSort(Ticket[] tickets, int low, int high) {
        if (low < high) {
            int pi = partition(tickets, low, high);

            quickSort(tickets, low, pi - 1);  
            quickSort(tickets, pi + 1, high); 
        }
    }

    static int partition(Ticket[] tickets, int low, int high) {
        double pivot = tickets[high].price; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price <= pivot) {
                i++;
                Ticket temp = tickets[i];
                tickets[i] = tickets[j];
                tickets[j] = temp;
            }
        }

        Ticket temp = tickets[i + 1];
        tickets[i + 1] = tickets[high];
        tickets[high] = temp;

        return i + 1;
    }

    static void displayTickets(Ticket[] tickets) {
        for (Ticket t : tickets) {
            t.display();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ticket[] tickets = {
            new Ticket("Concert A", 150.0),
            new Ticket("Concert B", 75.5),
            new Ticket("Concert C", 120.0),
            new Ticket("Concert D", 200.0),
            new Ticket("Concert E", 50.0)
        };

        System.out.println("Before Sorting:");
        displayTickets(tickets);

        quickSort(tickets, 0, tickets.length - 1);

        System.out.println("After Sorting (Cheapest First):");
        displayTickets(tickets);

        System.out.println("Top 3 Cheapest Tickets:");
        for (int i = 0; i < 3 && i < tickets.length; i++) {
            tickets[i].display();
        }
    }
}

