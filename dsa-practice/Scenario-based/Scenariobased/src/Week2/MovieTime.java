package Week2;

import java.util.Arrays;

public class MovieTime {

    public static void insertShowTime(int[] shows, int n, int newTime) {
        shows[n] = newTime;   
        int i = n - 1;

        while (i >= 0 && shows[i] > newTime) {
            shows[i + 1] = shows[i];
            i--;
        }

        shows[i + 1] = newTime;
    }

    public static void displayShows(int[] shows, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(shows[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] showTimes = new int[10];
        showTimes[0] = 900;   
        showTimes[1] = 1130;  
        showTimes[2] = 1400;  
        showTimes[3] = 1700;  

        int size = 4;

        System.out.println("Initial Showtimes:");
        displayShows(showTimes, size);

        int[] newShows = {1000, 1530, 1900};

        for (int time : newShows) {
            insertShowTime(showTimes, size, time);
            size++;
            System.out.println("After adding show at " + time + ":");
            displayShows(showTimes, size);
        }
    }
}

