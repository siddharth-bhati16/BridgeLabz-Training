package src.LinearBinarySearch;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Filereader {

    public static void main(String[] args) {
        String filePath = "example.txt"; // Path to your text file

        // Use try-with-resources to automatically close resources
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;

            // Read each line until end of file
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}