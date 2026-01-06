package src.Hashmaps;

import java.util.*;

public class SumArray {

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(target - num)) {
                System.out.println("Pair found: (" + num + ", " + (target - num) + ")");
                return true;
            }
            seen.add(num);
        }

        System.out.println("No pair with the given sum exists.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15, 3};
        int target = 10;

        hasPairWithSum(arr, target);
    }
}
