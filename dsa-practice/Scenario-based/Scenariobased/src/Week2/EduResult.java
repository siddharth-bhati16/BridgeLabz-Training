package Week2;

import java.util.Arrays;

public class EduResult {

    public static void main(String[] args) {

        int[] districtA = {35, 50, 65, 80};
        int[] districtB = {40, 55, 70, 85};
        int[] districtC = {30, 60, 75, 90};

        int[] allMarks = mergeArrays(districtA, districtB, districtC);

        System.out.println("Merged Marks (Before Final Sorting):");
        System.out.println(Arrays.toString(allMarks));

        mergeSort(allMarks, 0, allMarks.length - 1);

        System.out.println("\nFinal State-Wise Rank List (After Merge Sort):");
        System.out.println(Arrays.toString(allMarks));
    }

    private static int[] mergeArrays(int[]... districts) {
        int totalLength = 0;
        for (int[] d : districts) {
            totalLength += d.length;
        }

        int[] result = new int[totalLength];
        int index = 0;

        for (int[] d : districts) {
            for (int mark : d) {
                result[index++] = mark;
            }
        }
        return result;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
