
import java.util.Arrays;

public class First {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        maxElemnt(arr);
        System.out.println("maax element : "+ maxElemnt(arr));

    }

    static int maxElemnt(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
     

    // Time Complexity: O(n)



}
