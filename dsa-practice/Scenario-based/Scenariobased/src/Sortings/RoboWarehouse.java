package Sortings;

class RoboWarehouse {

    public static void insertPackage(int[] shelf, int currentSize, int newWeight) {
        int i = currentSize - 1;

        while (i >= 0 && shelf[i] > newWeight) {
            shelf[i + 1] = shelf[i];
            i--;
        }

        shelf[i + 1] = newWeight;
    }

    public static void main(String[] args) {
        int[] shelf = new int[10];
        int size = 0;

        int[] incomingPackages = { 12, 5, 8, 3, 10 };

        for (int weight : incomingPackages) {
            insertPackage(shelf, size, weight);
            size++;

            System.out.print("Shelf after inserting " + weight + ": ");
            for (int i = 0; i < size; i++) {
                System.out.print(shelf[i] + " ");
            }
            System.out.println();
        }
    }
}

