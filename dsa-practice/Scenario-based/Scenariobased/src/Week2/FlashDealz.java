package Week2;

import java.util.Random;

public class FlashDealz {

    static class Product {
        String name;
        int discount; 

        Product(String name, int discount) {
            this.name = name;
            this.discount = discount;
        }
    }

    public static void main(String[] args) {

        int size = 20; 
        Product[] products = new Product[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            products[i] = new Product("Product-" + (i + 1),
                    random.nextInt(90) + 1);
        }

        System.out.println("=== BEFORE SORTING (UNSORTED DISCOUNTS) ===");
        printTop(products, 10);

        quickSort(products, 0, products.length - 1);

        System.out.println("\n=== AFTER SORTING (TOP DISCOUNTS FIRST) ===");
        printTop(products, 10);
    }

    private static void quickSort(Product[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(Product[] arr, int low, int high) {

        int pivot = arr[high].discount;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].discount > pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(Product[] arr, int i, int j) {
        Product temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printTop(Product[] products, int topN) {
        for (int i = 0; i < Math.min(topN, products.length); i++) {
            System.out.println(products[i].name +
                    " → " + products[i].discount + "% OFF");
        }
    }
}

