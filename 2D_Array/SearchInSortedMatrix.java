public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int target = 5;
        System.out.println(search(arr, target));
        System.out.println(search(arr, target, 0, 0));
    }

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

    static boolean search(int[][] arr, int target, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
            return false;
        }
        if (arr[i][j] == target) {
            return true;
        } else if (arr[i][j] < target) {
            return search(arr, target, i, j + 1);
        } else {
            return search(arr, target, i + 1, j);
        }
    }
}
