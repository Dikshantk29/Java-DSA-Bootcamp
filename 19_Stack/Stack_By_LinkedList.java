public class Stack_By_LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class Stack {
        Node head;
        int size;

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public int pop() {
            if (size == 0) return -1;
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        public int peek() {
            if (size == 0) return -1;
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop());  // 3
        System.out.println(stack.peek()); // 2
    }
}
