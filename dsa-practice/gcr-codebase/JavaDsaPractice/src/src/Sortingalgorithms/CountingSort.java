package src.Sortingalgorithms;

public class CountingSort {

    public static void countingSort(int[] ages) {
        int n = ages.length;
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        for (int age : ages) {
            count[age - minAge]++;  
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {  
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 14, 13, 12, 18, 11};

        System.out.println("Original Ages:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }

        countingSort(studentAges);

        System.out.println("\n\nSorted Ages (Ascending):");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}
