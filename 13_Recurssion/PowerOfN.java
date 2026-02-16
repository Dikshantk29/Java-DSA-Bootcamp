public class PowerOfN {
    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }
    // time complexity is o(log n)
    // This function calculates the power of a number using recursion.
    static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return power(x * x, n / 2);
        } else {
            return x * power(x, n - 1);
        }
    }
}
