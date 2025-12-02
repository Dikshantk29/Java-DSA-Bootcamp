
import java.util.*;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        sortFn(arr);
    }

    public static void sortFn(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            // FINDING CORRECT POSITION
            while (prev >= 0 && curr < arr[prev]) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // INSERTING THE ELEMENT
            arr[prev + 1] = curr;
        }

        System.out.println(Arrays.toString(arr));
    }
}
