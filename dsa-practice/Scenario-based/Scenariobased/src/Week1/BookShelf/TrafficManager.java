package Week1.BookShelf;

import java.util.LinkedList;
import java.util.Queue;

class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
    }
}

public class TrafficManager {

    private Vehicle tail = null;              
    private int count = 0;
    private final int MAX_ROUNDABOUT = 5;     

    private Queue<String> waitingQueue = new LinkedList<>();

    public void addVehicle(String number) {
        if (count == MAX_ROUNDABOUT) {
            waitingQueue.offer(number);
            System.out.println("Roundabout full. Vehicle " + number + " added to waiting queue.");
            return;
        }

        Vehicle newVehicle = new Vehicle(number);

        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }
        count++;
        System.out.println("Vehicle " + number + " entered the roundabout.");
    }

    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout empty. No vehicle to remove.");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            tail = null;
        } else {
            tail.next = head.next;
        }

        System.out.println("Vehicle " + head.number + " exited the roundabout.");
        count--;

        if (!waitingQueue.isEmpty()) {
            addVehicle(waitingQueue.poll());
        }
    }

    public void printRoundabout() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout vehicles: ");
        Vehicle temp = tail.next;
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("(back to start)");
    }

    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.");
        } else {
            System.out.println("Waiting queue: " + waitingQueue);
        }
    }

    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager();

        tm.addVehicle("KA01");
        tm.addVehicle("KA02");
        tm.addVehicle("KA03");
        tm.addVehicle("KA04");
        tm.addVehicle("KA05");
        tm.addVehicle("KA06"); 

        tm.printRoundabout();
        tm.printQueue();

        tm.removeVehicle();
        tm.removeVehicle();

        tm.printRoundabout();
        tm.printQueue();
    }
}
