package Week2;

public class IceCreamRush {

    public static void main(String[] args) {

        String[] flavors = {
                "Vanilla", "Chocolate", "Strawberry", "Mango",
                "Butterscotch", "Pistachio", "Cookies & Cream", "Coffee"
        };

        int[] sales = {45, 80, 60, 30, 55, 40, 90, 35};

        System.out.println("=== BEFORE SORTING ===");
        printFlavors(flavors, sales);

        bubbleSort(flavors, sales);

        System.out.println("\n=== AFTER SORTING (BY POPULARITY) ===");
        printFlavors(flavors, sales);
    }

    private static void bubbleSort(String[] flavors, int[] sales) {
        int n = sales.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (sales[j] > sales[j + 1]) {

                    int tempSales = sales[j];
                    sales[j] = sales[j + 1];
                    sales[j + 1] = tempSales;

                    String tempFlavor = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = tempFlavor;
                }
            }
        }
    }

    private static void printFlavors(String[] flavors, int[] sales) {
        for (int i = 0; i < flavors.length; i++) {
            System.out.println(flavors[i] + " → " + sales[i] + " sales");
        }
    }
}
