package JavaStreams;

import java.io.*;

public class BufferedStreams{

    private static final int BUFFER_SIZE = 4096; 

    public static void main(String[] args) {

        String sourceFile = "largefile.dat"; 
        String unbufferedDest = "unbuffered_copy.dat";
        String bufferedDest = "buffered_copy.dat";

        copyUsingUnbufferedStreams(sourceFile, unbufferedDest);
        copyUsingBufferedStreams(sourceFile, bufferedDest);
    }

    private static void copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during unbuffered file copy.");
            return;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Unbuffered Stream Copy Time: " + duration / 1_000_000 + " ms");
    }

    private static void copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during buffered file copy.");
            return;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Buffered Stream Copy Time: " + duration / 1_000_000 + " ms");
    }
}
