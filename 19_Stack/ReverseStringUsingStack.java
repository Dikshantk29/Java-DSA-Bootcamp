import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        String str = "Hello";
        String reversedStr = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversedStr);
    }
    
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        // Push each character of the string onto the stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters from the stack and build the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }   
}
