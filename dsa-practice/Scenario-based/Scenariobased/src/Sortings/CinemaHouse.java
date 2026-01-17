package Sortings;

class CinemaHouse {

    public static void bubbleSort(int[] showTimes) {
        int n = showTimes.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (showTimes[j] > showTimes[j + 1]) {
                    int temp = showTimes[j];
                    showTimes[j] = showTimes[j + 1];
                    showTimes[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] showTimes = { 1800, 1430, 2100, 1230, 1600 };

        bubbleSort(showTimes);

        System.out.print("Sorted Movie Showtimes: ");
        for (int time : showTimes) {
            System.out.print(time + " ");
        }
    }
}
