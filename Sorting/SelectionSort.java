package Sorting;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        sortFn(arr);
    }

    public static void sortFn(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i +  1; j < arr.length; j++) { 
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            // swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}
