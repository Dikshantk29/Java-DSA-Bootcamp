public class FirstOccurence {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 4 };
        System.out.println(firstOccurence(arr, 0, 4)); // 3
        int[] arr2 = { 1, 2, 3, 4, 5 };
        System.out.println(firstOccurence(arr2, 0, 6)); // -1
        int[] arr3 = { 1 };
        System.out.println(firstOccurence(arr3, 0, 1)); // 0


        int[] arr4 = { 1, 2, 3, 4, 5, 4 };
        System.out.println(lastOccurence(arr4, 0, 4)); // 5

    }

    //time complexity is o(n)
    // This function finds the first occurrence of a target element in an array using recursion.
    static int firstOccurence(int[] arr, int i, int target) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return firstOccurence(arr, i + 1, target);
    }



    // This function finds the last occurrence of a target element in an array using recursion.
    static int lastOccurence(int[] arr, int i, int target) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, i + 1, target);
        if (isFound == -1 && arr[i] == target) {
            return i;
        }
        return isFound;
    }
}
