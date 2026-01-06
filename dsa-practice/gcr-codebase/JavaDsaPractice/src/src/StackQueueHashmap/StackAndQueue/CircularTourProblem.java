package src.StackQueueHashmap.StackAndQueue;

import java.util.*;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {

    public static int findStartingPump(PetrolPump[] pumps) {
        int n = pumps.length;
        Queue<PetrolPump> queue = new LinkedList<>();
        Collections.addAll(queue, pumps);

        int start = 0;
        int surplus = 0;   
        int deficit = 0;   
        for (int i = 0; i < n; i++) {
            PetrolPump pump = queue.poll();
            surplus += pump.petrol - pump.distance;

            if (surplus < 0) {
                
                start = i + 1;
                deficit += surplus; 
                surplus = 0;
            }

            queue.offer(pump);
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int start = findStartingPump(pumps);
        if (start != -1) {
            System.out.println("Start at pump index: " + start);
        } else {
            System.out.println("No solution possible");
        }
    }
}
