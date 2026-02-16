import java.util.ArrayList;

public class Stack_By_ArrayList {

    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (list.size() == 0) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (list.size() == 0) {
                return -1;
            }
            return list.get(list.size() - 1);
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
