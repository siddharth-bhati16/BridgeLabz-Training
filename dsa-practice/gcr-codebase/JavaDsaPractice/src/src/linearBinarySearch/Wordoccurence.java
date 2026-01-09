package src.LinearBinarySearch;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Wordoccurence {

    public static void main(String[] args) {
        String filePath = "example.txt"; 
        String targetWord = "Java";      
        int count = 0;                  
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

