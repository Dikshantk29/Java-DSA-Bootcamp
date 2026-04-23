
public class TIilingProblem {
    public static void main(String[] args) {

        int n = 5;
        System.out.println("Number of ways to tile a 2 x " + n + " board: " + tilingProblem(n));

    }

    static int tilingProblem(int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }
}
