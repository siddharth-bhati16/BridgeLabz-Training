package src.SubmissionOfAlgorithm;

import java.io.*;

public class LargeFileReading {

    private static final String FILE_PATH = "largefile.txt"; 

    public static void readUsingFileReader() throws IOException {
        FileReader reader = new FileReader(FILE_PATH);
        int data;
        while ((data = reader.read()) != -1) {
        }
        reader.close();
    }

    public static void readUsingInputStreamReader() throws IOException {
        InputStreamReader reader =
                new InputStreamReader(new FileInputStream(FILE_PATH));
        int data;
        while ((data = reader.read()) != -1) {
        }
        reader.close();
    }

    public static void main(String[] args) {

        try {
            long start, end;

            start = System.nanoTime();
            readUsingFileReader();
            end = System.nanoTime();
            System.out.println("FileReader Time: " +
                    (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            readUsingInputStreamReader();
            end = System.nanoTime();
            System.out.println("InputStreamReader Time: " +
                    (end - start) / 1_000_000.0 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

