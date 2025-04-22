public class ArraySort {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(isSorted(arr, 0)); // true
        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println(isSorted(arr2, 0)); // true
        int[] arr3 = { 1, 2, 3, 4, 5, 4 };
        System.out.println(isSorted(arr3, 0)); // false
        int[] arr4 = { 1 };
        System.out.println(isSorted(arr4, 0)); // true

    }

    // time complexity is o(n)
    // This function checks if the array is sorted in ascending order using
    // recursion.
    static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

}