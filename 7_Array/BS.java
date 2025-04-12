public class BS {
    public static void main(String[] args) {
        {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int target = 5;
            int result = binarySearch(arr, target);
            if (result == -1)
                System.out.println("Element not present in array");
            else
                System.out.println("Element found at index " + result);
        }
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    // This program will output: Element found at index 4
    //time complexity is O(log n)
}
