
import java.util.Stack;

public class MaxAreaInHistogram {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Max area using brute force approach: " + maxArea(arr));

        // optimized approach using stack
        System.out.println("Max area using optimized approach: " + maxAreaOptimized(arr));
    }

    // brute force approach
    static int maxArea(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int minHeight = arr[i];
            for (int j = i; j < arr.length; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    // optimized approach using stack
    static int maxAreaOptimized(int[] arr) {
        int maxArea = 0;
        int[] nsr = new int[arr.length]; // next smaller right
        int[] nsl = new int[arr.length]; // next smaller left


        // next smaller right
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsr[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        // next smaller left
        stack.clear(); // clear stack to reuse for next smaller left
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }


        // calculate  curent area and max area
        for (int i = 0; i < arr.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}