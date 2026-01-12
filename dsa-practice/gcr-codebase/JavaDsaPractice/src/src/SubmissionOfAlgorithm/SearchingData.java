package src.SubmissionOfAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class SearchingData {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int size = 1_000_000;
        int[] data = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size);
        }

        int target = data[size - 1];

        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();

        Arrays.sort(data);

        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();

        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time: " +
                (endLinear - startLinear) / 1_000_000.0 + " ms");
        System.out.println("Binary Search Time: " +
                (endBinary - startBinary) / 1_000_000.0 + " ms");
    }
}
