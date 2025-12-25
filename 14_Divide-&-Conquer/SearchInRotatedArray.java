public class SearchInRotatedArray {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int ans = search(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }

    public static int search(int arr[], int tar, int si, int ei) {


        if(si > ei){
            return -1;
        }

        int mid = si + (ei - si) / 2;
        // case found
        if (arr[mid] == tar) {
            return mid;

        }

        // case on line l1
        if (arr[si] <= arr[mid]) {

            // case left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid);

            } else {
                // right
                return search(arr, tar, mid + 1, ei);
            }

        } else { // (arr[mid] <= arr[ei])//case on l2
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                return search(arr, tar, si, mid - 1);
            }

        }
    }

}
