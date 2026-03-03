

import java.util.Queue;
import java.util.LinkedList;
public class ImplementingQueueUsingJavaCollectionFramework {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>() ; //because queue is interface
         

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();

        }
    }
}
