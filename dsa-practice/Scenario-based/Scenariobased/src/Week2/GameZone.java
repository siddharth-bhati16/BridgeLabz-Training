package Week2;

import java.util.Random;

public class GameZone {

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void quickSort(Player[] players, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(players, low, high);
            quickSort(players, low, pivotIndex - 1);
            quickSort(players, pivotIndex + 1, high);
        }
    }

    private static int partition(Player[] players, int low, int high) {
        int pivot = players[high].score;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (players[j].score >= pivot) { 
                i++;
                swap(players, i, j);
            }
        }
        swap(players, i + 1, high);
        return i + 1;
    }

    private static void swap(Player[] players, int i, int j) {
        Player temp = players[i];
        players[i] = players[j];
        players[j] = temp;
    }

    public static void display(Player[] players) {
        System.out.println(" Leaderboard:");
        for (int i = 0; i < players.length; i++) {
            System.out.println(
                (i + 1) + ". " + players[i].name + " - Score: " + players[i].score
            );
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("ram", 850),
            new Player("tarun", 1200),
            new Player("honey", 600),
            new Player("rohit", 1500),
            new Player("mohit", 900),
            new Player("sonu", 1500),
            new Player("sunny", 700)
        };

        System.out.println("Before Sorting:");
        display(players);

        quickSort(players, 0, players.length - 1);

        System.out.println("After Quick Sort (High Score Ranking):");
        display(players);
    }
}
