package Sortings;

class HospitalQueue {

    static class Patient {
        String name;
        int arrivalTime;    
        int criticality;   

        Patient(String name, int arrivalTime, int criticality) {
            this.name = name;
            this.arrivalTime = arrivalTime;
            this.criticality = criticality;
        }

        void display() {
            System.out.println(name + " | Arrival: " + arrivalTime + " | Criticality: " + criticality);
        }
    }

    
    static void sortByCriticality(Patient[] patients) {
        int n = patients.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (patients[j].criticality < patients[j + 1].criticality) {
                    Patient temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }

    static void displayQueue(Patient[] patients) {
        System.out.println("Patient Queue Sorted by Criticality:");
        for (Patient p : patients) {
            p.display();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Patient[] patients = {
            new Patient("Alice", 1, 5),
            new Patient("Bob", 2, 8),
            new Patient("Charlie", 3, 3),
            new Patient("Diana", 4, 10),
            new Patient("Eve", 5, 7)
        };

        System.out.println("Before Sorting:");
        displayQueue(patients);

        sortByCriticality(patients);

        System.out.println("After Sorting:");
        displayQueue(patients);
    }
}

