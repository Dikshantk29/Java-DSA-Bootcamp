import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3 };
        int[] nextGreater = new int[arr.length];
        findNextGreater(arr, nextGreater);

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.println("index: " + i + " -> " + nextGreater[i]);
        }
        System.out.println("Optimized approach:");
        findNextGreaterOptimized(arr, nextGreater);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.println("index: " + i + " -> " + nextGreater[i]);
        }
    }

    // Brute force approach
    public static void findNextGreater(int[] arr, int[] nextGreater) {
        for (int i = 0; i < arr.length; i++) {
            nextGreater[i] = -1; // Initialize with -1, assuming no greater element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    nextGreater[i] = arr[j];
                    break; // Break after finding the next greater element
                }
            }
        }
    }
    // Optimized approach using stack
    public static void findNextGreaterOptimized(int[] arr, int[] nextGreater) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1; // No greater element
            } else {
                nextGreater[i] = s.peek(); // Next greater element
            }

            s.push(arr[i]); // Push current element onto stack
        }
    }
}
