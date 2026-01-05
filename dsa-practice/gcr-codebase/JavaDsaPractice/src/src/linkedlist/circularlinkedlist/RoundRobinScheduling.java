package src.linkedlist.circularlinkedlist;

class Process {
    int processId;
    int burstTime;
    int remainingTime; // for round-robin
    int priority;      // optional, not used in round-robin
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private int size = 0;

    /* Add process at the end */
    void addProcess(int id, int burst, int priority) {
        Process newProcess = new Process(id, burst, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
        size++;
    }

    /* Remove process by ID */
    void removeProcess(int id) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;
        boolean found = false;

        do {
            if (temp.processId == id) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) return;

        if (temp == head) {
            // only one process
            if (head.next == head) {
                head = null;
            } else {
                // find tail to update circular link
                Process tail = head;
                while (tail.next != head)
                    tail = tail.next;
                head = head.next;
                tail.next = head;
            }
        } else {
            prev.next = temp.next;
        }
        size--;
    }

    /* Display the circular queue */
    void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        Process temp = head;
        do {
            System.out.print("P" + temp.processId + "(" + temp.remainingTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    /* Simulate round-robin scheduling */
    void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int n = size;

        int[] waitingTime = new int[100]; // assuming max 100 processes
        int[] turnaroundTime = new int[100];

        Process temp = head;

        // Initialize waiting times to 0
        for (int i = 0; i < 100; i++) waitingTime[i] = 0;

        System.out.println("\n--- Round-Robin Scheduling ---");

        while (size > 0) {
            // Execute process
            if (temp.remainingTime > 0) {
                int executedTime = Math.min(temp.remainingTime, timeQuantum);
                System.out.println("Executing P" + temp.processId + " for " + executedTime + " units");
                temp.remainingTime -= executedTime;

                // Increase waiting time for other processes
                Process p = temp.next;
                while (p != temp) {
                    if (p.remainingTime > 0)
                        waitingTime[p.processId] += executedTime;
                    p = p.next;
                }

                // If process finished
                if (temp.remainingTime == 0) {
                    turnaroundTime[temp.processId] = waitingTime[temp.processId] + temp.burstTime;
                    Process toRemove = temp;
                    temp = temp.next;
                    removeProcess(toRemove.processId);
                    displayQueue();
                    continue; // skip temp=temp.next
                }
            }
            temp = temp.next;
        }

        // Calculate averages
        int processCount = 0;
        for (int i = 0; i < 100; i++) {
            if (turnaroundTime[i] > 0) {
                totalWaitingTime += waitingTime[i];
                totalTurnaroundTime += turnaroundTime[i];
                processCount++;
            }
        }

        double avgWT = (double) totalWaitingTime / processCount;
        double avgTAT = (double) totalTurnaroundTime / processCount;

        System.out.printf("\nAverage Waiting Time: %.2f\n", avgWT);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTAT);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler rr = new RoundRobinScheduler();

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 4, 2);
        rr.addProcess(3, 6, 1);
        rr.addProcess(4, 8, 3);

        rr.displayQueue();

        int timeQuantum = 3;
        rr.simulate(timeQuantum);
    }
}
