package src.LinearBinarySearch;

public class CompareStringbuilderStringbuffer {

    public static void main(String[] args) {
        int n = 1_000_000; 
        String str = "hello";

        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();

        for (int i = 0; i < n; i++) {
            stringBuffer.append(str);
        }

        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        System.out.println("Time taken by StringBuffer: " + durationBuffer / 1_000_000 + " ms");

        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();

        for (int i = 0; i < n; i++) {
            stringBuilder.append(str);
        }

        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuilder: " + durationBuilder / 1_000_000 + " ms");
    }
}

