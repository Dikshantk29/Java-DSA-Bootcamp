
import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {

        int[] arr = { 4, 3, 7, 1, 2 };

        int ans = solve(arr);
        System.out.println("ans: " + ans);
    }

    static int solve(int[] arr) {

        Arrays.sort(arr);
        int wt = 0;
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            wt += t;
            t += arr[i];
        }
        return wt/arr.length;
    }
}
