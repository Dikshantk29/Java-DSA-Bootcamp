import java.util.Stack;

public class Duplicate_Parenthess {
    public static void main(String[] args) {
        String s1 = "((a+b))";
        String s2 = "(a+(b)/c)";
        String s3 = "((a+b)*(c-d))";

        System.out.println(duplicateParenthesis(s1));
        System.out.println(duplicateParenthesis(s2));
        System.out.println(duplicateParenthesis(s3));
    }

    static boolean duplicateParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    stack.pop(); // pop opening bracket
                }
            } else {
                // opening
                stack.push(ch);
            }
        }
        return false;

    }
}
