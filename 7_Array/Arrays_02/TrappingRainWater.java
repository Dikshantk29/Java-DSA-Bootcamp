package Arrays_02;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 6, 3, 2, 5 };
        int value = approach_1(height);
        System.out.println("Trapped water level: "+value);

    }

    public static int approach_1(int[] height) {
        // auxilary approach

        // left max boundary
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);

        }

        // right max boundary
        int[] rightMax = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // loop
        int n = height.length;
        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            // waterlevel = min(leftmax bound -rightmax bound)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            // trapped water = waterlevel - height[i]
            trappedWater += (waterlevel - height[i]);

        }
        return trappedWater;

    }
}
