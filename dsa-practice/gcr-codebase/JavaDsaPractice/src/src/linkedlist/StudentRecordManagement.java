package src.linkedlist;
import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head;

    // Add at beginning
    void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Add at specific position
    void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            System.out.println("Student record deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Student record deleted.");
    }

    // Search by roll number
    void searchStudent(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Roll: " + temp.roll);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade
    void updateGrade(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    void displayStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("\nRoll: " + temp.roll);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    String grade = sc.next();

                    if (choice == 1)
                        list.addAtBeginning(roll, name, age, grade);
                    else if (choice == 2)
                        list.addAtEnd(roll, name, age, grade);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, roll, name, age, grade);
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    list.deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    list.searchStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll Number: ");
                    int r = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    String g = sc.next();
                    list.updateGrade(r, g);
                    break;

                case 7:
                    list.displayStudents();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
