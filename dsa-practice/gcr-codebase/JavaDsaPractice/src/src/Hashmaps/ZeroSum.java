package src.Hashmaps;

import java.util.*;

public class ZeroSum {

    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> cumSumMap = new HashMap<>();
        int cumSum = 0;

        cumSumMap.put(0, new ArrayList<>());
        cumSumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumSum += arr[i];

            if (cumSumMap.containsKey(cumSum)) {
                List<Integer> startIndices = cumSumMap.get(cumSum);
                for (int start : startIndices) {
                    System.out.print("Subarray found from index " + (start + 1) + " to " + i + ": [");
                    for (int k = start + 1; k <= i; k++) {
                        System.out.print(arr[k]);
                        if (k < i) System.out.print(", ");
                    }
                    System.out.println("]");
                }
            }

            cumSumMap.putIfAbsent(cumSum, new ArrayList<>());
            cumSumMap.get(cumSum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
}

