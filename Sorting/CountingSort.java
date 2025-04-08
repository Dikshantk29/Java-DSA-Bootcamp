package Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1, -1, -3 };
        sortFn(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void sortFn(int arr[]) {
        if (arr.length == 0) {
            return; // Handle empty array
        }

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        // Find the largest and smallest elements
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
            smallest = Math.min(smallest, arr[i]);
        }

        int[] count = new int[largest - smallest + 1]; // Adjust size for range including negatives

        // Count the occurrences
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - smallest]++; // Shift index to handle negatives
        }

        // Reconstruct the sorted array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j++] = i + smallest; // Shift back to original value
                count[i]--;
            }
        }
    }
}
