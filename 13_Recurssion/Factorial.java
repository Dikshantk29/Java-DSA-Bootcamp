public class Factorial {
    public static void main(String[] args) {
      // Factorial of 5 = 5 * 4 * 3 * 2 * 1 = 120
      // Factorial of 0 = 1
        System.out.println(factorial(5)); // 5! = 120
    }
    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
