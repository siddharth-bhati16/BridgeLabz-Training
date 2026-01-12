package Week1.BookShelf;

class HospitalUnit {
    String name;
    boolean available;
    HospitalUnit next;

    HospitalUnit(String name, boolean available) {
        this.name = name;
        this.available = available;
        this.next = null;
    }
}

class AmbulanceRoutes {
    private HospitalUnit head = null;

    public void addUnit(String name, boolean available) {
        HospitalUnit newUnit = new HospitalUnit(name, available);

        if (head == null) {
            head = newUnit;
            newUnit.next = head;
        } else {
            HospitalUnit temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newUnit;
            newUnit.next = head;
        }
    }

    // Remove unit under maintenance
    public void removeUnit(String name) {
        if (head == null) return;

        HospitalUnit curr = head;
        HospitalUnit prev = null;

        do {
            if (curr.name.equals(name)) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        HospitalUnit temp = head;
                        while (temp.next != head) {
                            temp = temp.next;
                        }
                        head = head.next;
                        temp.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                }
                System.out.println(name + " is under maintenance and removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Find nearest available unit
    public void redirectPatient() {
        if (head == null) {
            System.out.println("No hospital units available.");
            return;
        }

        HospitalUnit temp = head;
        do {
            if (temp.available) {
                System.out.println("Patient redirected to: " + temp.name);
                return;
            }
            System.out.println(temp.name + " unavailable, moving to next unit...");
            temp = temp.next;
        } while (temp != head);

        System.out.println("No available units found!");
    }

    public void displayRoute() {
        if (head == null) return;

        HospitalUnit temp = head;
        System.out.print("Ambulance Route: ");
        do {
            System.out.print(temp.name + " → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Emergency)");
    }
}

public class AmbulanceRoute {
    public static void main(String[] args) {

        AmbulanceRoutes route = new AmbulanceRoutes();

        route.addUnit("Emergency", false);
        route.addUnit("Radiology", false);
        route.addUnit("Surgery", true);
        route.addUnit("ICU", false);

        route.displayRoute();

        System.out.println("\nPatient Arrival:");
        route.redirectPatient();

        System.out.println("\nMaintenance Update:");
        route.removeUnit("Radiology");

        route.displayRoute();

        System.out.println("\nNext Patient Arrival:");
        route.redirectPatient();
    }
}

