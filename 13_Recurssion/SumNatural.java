public class SumNatural {
    public static void main(String[] args) {
        System.out.println(sum(5)); // 1 + 2 + 3 + 4 + 5 = 15
        // Sum of first 5 natural numbers = 1 + 2 + 3 + 4 + 5 = 15  
    }
    static int sum(int n) {
        if (n == 1) {
            return 1; // Base case: sum of 1 is 1
        }
        return n + sum(n - 1);
    }

    static void printFn (int n) {
        if (n == 0) {
            return; // Base case: do nothing
        }
        System.out.println(n); // Print the current number
    }
}



