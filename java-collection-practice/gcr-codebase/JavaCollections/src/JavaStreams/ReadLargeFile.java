package JavaStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {

    public static void main(String[] args) {

        String filePath = "largefile.txt"; 
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }
    }
}

