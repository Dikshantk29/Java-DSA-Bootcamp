static boolean search(int[][] arr, int target, int i, int j) {
    if (i >= arr.length || j < 0) {
        return false;
    }
    if (arr[i][j] == target) {
        return true;
    } else if (arr[i][j] > target) {
        return search(arr, target, i, j - 1); // Move left
    } else {
        return search(arr, target, i + 1, j); // Move down
    }
}
