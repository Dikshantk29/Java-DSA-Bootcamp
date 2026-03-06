import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueReversal {
    public static void main(String[] args) {
        //stack approach
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Original Queue: " + q);
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }
}