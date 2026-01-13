package Week1.BookShelf;

import java.util.Scanner;

class Compartment {
    int number;
    String service; 
    Compartment prev;
    Compartment next;

    Compartment(int number, String service) {
        this.number = number;
        this.service = service;
    }
}

public class TrainCompanion {

    private Compartment head;
    private Compartment tail;

    public void addCompartment(int number, String service) {
        Compartment newNode = new Compartment(number, service);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeCompartment(int number) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.number == number) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                System.out.println("Compartment " + number + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Compartment not found.");
    }

    public void traverseForward() {
        Compartment temp = head;
        System.out.println("Forward Traversal:");
        while (temp != null) {
            System.out.println("Compartment " + temp.number + " - " + temp.service);
            temp = temp.next;
        }
    }

    public void traverseBackward() {
        Compartment temp = tail;
        System.out.println("Backward Traversal:");
        while (temp != null) {
            System.out.println("Compartment " + temp.number + " - " + temp.service);
            temp = temp.prev;
        }
    }

    public void searchService(String service) {
        Compartment temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.service.equalsIgnoreCase(service)) {
                System.out.println("Service '" + service + "' found in Compartment " + temp.number);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Service not found.");
    }

    public void showAdjacent(int number) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.number == number) {
                if (temp.prev != null)
                    System.out.println("Previous: Compartment " + temp.prev.number);
                else
                    System.out.println("No previous compartment.");

                if (temp.next != null)
                    System.out.println("Next: Compartment " + temp.next.number);
                else
                    System.out.println("No next compartment.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Compartment not found.");
    }

    public static void main(String[] args) {
        TrainCompanion train = new TrainCompanion();

        train.addCompartment(1, "Sleeper");
        train.addCompartment(2, "WiFi");
        train.addCompartment(3, "Pantry");
        train.addCompartment(4, "AC");

        train.traverseForward();
        train.traverseBackward();

        train.searchService("Pantry");
        train.showAdjacent(3);

        train.removeCompartment(2);
        train.traverseForward();
    }
}
