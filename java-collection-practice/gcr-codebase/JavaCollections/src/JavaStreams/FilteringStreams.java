package JavaStreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilteringStreams{

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(sourceFile));
            bw = new BufferedWriter(new FileWriter(destinationFile));

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File processed successfully.");

        } catch (IOException e) {
            System.out.println("Error while reading or writing the file.");

        } finally {
            try {
                if (br != null)
                    br.close();
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
