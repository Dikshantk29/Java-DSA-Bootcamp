import java.util.Arrays;
//time complexity = O(nlogn)
//space complexity = O(logn)
//worst case time complexity = O(n^2)

public class QuickSort {
    public static void main(String[] args) {
        int arr[] ={7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int arr[], int s, int e) {

        // base case
        if (s >= e) {
            return;
        }
        
        // lastlement
        int pivotIndex = partition(arr, s, e);
        quickSort(arr, s, pivotIndex - 1);// left part
        quickSort(arr, pivotIndex + 1, e);// right part

    }

    public static int partition(int arr[], int s, int e) {
        int pivot = arr[e];

        int i = s - 1;// to make place for element smaller than pivot

        for (int j = s; j < e; j++){
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        int temp = arr[e];
        arr[e] = arr[i];
        arr[i] = temp;

        return i;

    }
}
