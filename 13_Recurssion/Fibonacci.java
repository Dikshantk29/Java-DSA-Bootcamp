public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5)); // 0 1 1 2 3 5
        // Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, ...
    }


    //time complexity is o(n^2)
    static int fibonacci(int n) {
        if (n == 0) {
            return 0; // Base case: F(0) = 0
        }
        if (n == 1) {
            return 1; // Base case: F(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }
    static void printFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
