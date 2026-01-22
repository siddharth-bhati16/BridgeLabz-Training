package JavaStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Department: " + department +
               ", Salary: " + salary;
    }
}

public class Serialization {

    public static void main(String[] args) {

        String filename = "employees.dat";
        List<Employee> employeeList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Employee " + (i + 1));

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();

                employeeList.add(new Employee(id, name, dept, salary));
            }

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(employeeList);
            oos.close();

            System.out.println("\nEmployees serialized successfully.\n");

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(filename));
            List<Employee> retrievedList =
                    (List<Employee>) ois.readObject();
            ois.close();

            System.out.println("Deserialized Employee Details:");
            for (Employee emp : retrievedList) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            System.out.println("I/O Error occurred.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization.");
        } finally {
            sc.close();
        }
    }
}
