import java.util.Stack;
class ReverseAStack{
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();// Pop the top element
        reverseStack(stack); // Reverse the remaining stack
        insertAtBottom(stack, top); // Insert the popped element at the bottom of the reversed stack
    }
    public static void insertAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, data);
        stack.push(top);
    }

}