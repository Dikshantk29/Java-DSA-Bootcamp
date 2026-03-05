import java.util.LinkedList;
import java.util.Queue;

public class Interleave2HalveOfAQueue {
    // 1. Interleave the first half of the queue with the second half of the queue
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);   
        q.add(9);
        q.add(10);
        interleave(q);
        System.out.println(q); 
        // Output: [1, 6, 2, 7, 3, 8, 4, 9, 5, 10]
    }

    public static void interleave(Queue<Integer> q) {
        int n = q.size();
        if (n % 2 != 0) {
            System.out.println("Queue size must be even.");
            return;
        }
        int halfSize = n / 2;
        Queue<Integer> firstHalf = new LinkedList<>();
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(q.poll());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.poll());
            q.add(q.poll());
        }
    }
}
