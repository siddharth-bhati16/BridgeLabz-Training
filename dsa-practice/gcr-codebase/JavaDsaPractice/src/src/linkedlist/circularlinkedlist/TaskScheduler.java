package src.linkedlist.circularlinkedlist;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;
    private int size = 0;

    /* Add task at beginning */
    void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;

            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
        size++;
    }

    /* Add task at end */
    void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newTask;
            newTask.next = head;
        }
        size++;
    }

    /* Add task at specific position (1-based index) */
    void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        } else if (pos > size) {
            addAtEnd(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < pos - 1; i++)
            temp = temp.next;

        newTask.next = temp.next;
        temp.next = newTask;
        size++;
    }

    /* Remove task by Task ID */
    void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head;
        Task prev = null;
        boolean found = false;

        do {
            if (temp.taskId == id) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task not found.");
            return;
        }

        if (temp == head) { // remove head
            Task last = head;
            while (last.next != head)
                last = last.next;

            if (head.next == head) { // only one node
                head = null;
                current = null;
            } else {
                head = head.next;
                last.next = head;
                if (current == temp)
                    current = head;
            }
        } else { // remove non-head
            prev.next = temp.next;
            if (current == temp)
                current = temp.next;
        }

        size--;
        System.out.println("Task removed successfully.");
    }

    /* View current task */
    void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks in the scheduler.");
        } else {
            displayTask(current);
        }
    }

    /* Move to next task */
    void moveToNextTask() {
        if (current == null) {
            System.out.println("No tasks in the scheduler.");
        } else {
            current = current.next;
        }
    }

    /* Display all tasks starting from head */
    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("\nAll Tasks:");
        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    /* Search tasks by priority */
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks found with priority " + priority);
    }

    /* Helper: Display single task */
    void displayTask(Task task) {
        System.out.println(
            task.taskId + " | " +
            task.taskName + " | Priority: " +
            task.priority + " | Due: " +
            task.dueDate
        );
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Finish assignment", 1, "2026-01-06");
        scheduler.addAtEnd(2, "Read book", 2, "2026-01-07");
        scheduler.addAtBeginning(3, "Check emails", 1, "2026-01-05");
        scheduler.addAtPosition(2, 4, "Prepare presentation", 3, "2026-01-08");

        scheduler.displayAllTasks();

        System.out.println("\nCurrent Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMove to next task:");
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        System.out.println("\nTasks with priority 1:");
        scheduler.searchByPriority(1);

        scheduler.removeById(3);
        System.out.println("\nAfter removing Task ID 3:");
        scheduler.displayAllTasks();
    }
}
