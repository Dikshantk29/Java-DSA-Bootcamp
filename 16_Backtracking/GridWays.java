public class GridWays {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int ways = gridWays(0, 0, n, m);
        System.out.println("Ways: " + ways);
    }

    public static int gridWays(int i, int j, int n, int m) {

        // base case
        if (i == n - 1 && j == m - 1) {
            return 1;// for last cell

        } else if (i == n || j == n) {
            return 0;// boundary crossed.

        }
        // kaam
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;

    }
}
