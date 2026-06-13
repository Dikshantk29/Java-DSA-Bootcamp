public class JumpGame1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 0, 2, 5 };

        boolean ans = solve(arr);
        System.out.println("ans: " + ans);
    }

    static boolean solve(int[] arr) {

        int n = arr.length;
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
        }
        return true;
    }
}
