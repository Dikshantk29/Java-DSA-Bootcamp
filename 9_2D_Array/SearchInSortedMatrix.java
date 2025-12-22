public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int target = 5;

        System.out.println(search(arr, target)); // Brute force
        System.out.println(search(arr, target, 0, arr[0].length - 1)); 
    }

    // Brute-force search
    static boolean search(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimized recursive search from top-right
    static boolean search(int[][] arr, int target, int i, int j) {
        if (i >= arr.length || j < 0) {
            return false;
        }
        if (arr[i][j] == target) {
            return true;
        } else if (arr[i][j] > target) {
            return search(arr, target, i, j - 1); // move left
        } else {
            return search(arr, target, i + 1, j); // move down
        }
    }
}
