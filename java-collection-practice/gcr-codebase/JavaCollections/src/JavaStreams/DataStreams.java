package JavaStreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams {

    public static void main(String[] args) {

        String filename = "student.dat";

        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(filename))) {

            int rollNo = 101;
            String name = "John Doe";
            double gpa = 3.85;

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing student data.");
        }

        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(filename))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("Error reading student data.");
        }
    }
}
