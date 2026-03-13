import java.util.Deque;
import java.util.LinkedList;

class StackAndQueueUsingDeque {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        // push
        public void push(int data) {
            deque.addLast(data);
        }

        // pop
        public int pop() {
            return deque.removeLast();
        }

        // peek
        public int peek() {
            return deque.getLast();
        }




    }

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        // add
        public void add(int data) {
            deque.addLast(data);
        }

        // remove
        public int remove() {
            return deque.removeFirst();
        }

        // peek
        public int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        System.out.println("--------Stack----------");
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());

        System.out.println("--------Queue----------");
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.peek());   
        

    }
}
