package Week1.BookShelf;

class ParcelTracker {

    static class Node {
        String stage;
        Node next;

        Node(String stage) {
            this.stage = stage;
            this.next = null;
        }
    }

    Node head;

    void addStage(String stage) {
        Node newNode = new Node(stage);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addCheckpoint(String afterStage, String newStage) {
        Node temp = head;

        while (temp != null && !temp.stage.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found. Checkpoint not added.");
            return;
        }

        Node newNode = new Node(newStage);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void trackParcel() {
        if (head == null) {
            System.out.println("Parcel is lost (no tracking data).");
            return;
        }

        Node temp = head;
        System.out.print("Parcel Status: ");

        while (temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

     
        tracker.addCheckpoint("Shipped", "Warehouse Check");

      
        tracker.trackParcel();
    }
}

