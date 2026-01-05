
package src.StackQueueHashmap.StackAndQueue;
import java.util.Stack;

public class QueueStack1 {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); 
        System.out.println(queue.peek());   
        System.out.println(queue.dequeue()); 
        System.out.println(queue.dequeue()); 
    }
}

