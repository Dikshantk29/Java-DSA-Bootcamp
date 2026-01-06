
import java.util.ArrayList;
import java.util.Arrays;

public class ContainWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
        System.out.println(maxArea(height));
        System.out.println(maxAreaOptimal(height));
    }

    // brute force approach O(n^2)
    public static int maxArea(ArrayList<Integer> height) {
        int maxArea = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int area = Math.min(height.get(i), height.get(j)) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // optimal approach O(n) 2 pointer approach
    public static int maxAreaOptimal(ArrayList<Integer> height) {
        int maxArea = 0;
        int left = 0;
        int right = height.size() - 1;
        while (left < right) {
            int area = Math.min(height.get(left), height.get(right)) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // vs trapping rain water
    // This problem is different from trapping rain water because here we are looking for the maximum area between two lines, not the maximum amount of water that can be stored.
}
