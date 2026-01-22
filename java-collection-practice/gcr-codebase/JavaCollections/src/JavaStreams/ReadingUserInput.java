package JavaStreams;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadingUserInput {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;

        try {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer = new FileWriter("user_details.txt");

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("\nData saved successfully to user_details.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to the file.");
        } finally {
            try {
                if (writer != null)
                    writer.close();
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
