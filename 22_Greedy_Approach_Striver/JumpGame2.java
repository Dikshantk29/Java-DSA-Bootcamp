public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 4, 1, 1, 1, 2 };
        System.out.println("Minimum jumps required by recursive approach: " + jump(nums, 0, 0));
        System.out.println("Minimum jumps required by greedy approach: " + jumpGreedy(nums));
    }

    // Recursive Approach

    public static int jump(int[] nums, int index, int jumps) {
        if (index >= nums.length - 1) {
            return jumps;
        }

        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            minJumps = Math.min(minJumps, jump(nums, index + i, jumps + 1));
        }
        return minJumps;
    }


    // Greedy Approach
    public static int jumpGreedy(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}