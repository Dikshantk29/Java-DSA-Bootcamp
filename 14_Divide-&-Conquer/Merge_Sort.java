
import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSortAlgo(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortAlgo(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        // kaam
        int mi = si + (ei - si) / 2;
        mergeSortAlgo(arr, si, mi);

        mergeSortAlgo(arr, mi + 1, ei);

        mergeAlgo(arr, si, mi, ei);

    }

    public static void mergeAlgo(int[] arr, int si, int mi, int ei) {
       
        int temp[] = new int[ei - si + 1];
        int i = si;// left
        int j = mi + 1;// right
        int k = 0;// tmep

        while (i <= mi && j <= ei) {

            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;

            } else {
                temp[k] = arr[j];
                j++;

            }
            k++;
        }

        while (i <= mi) {
            temp[k++] = arr[i++];

        }
        while (j <= ei) {
            temp[k++] = arr[j++];

        }

        
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
       
        

    }
}
