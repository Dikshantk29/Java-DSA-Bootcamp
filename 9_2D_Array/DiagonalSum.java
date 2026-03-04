public class DiagonalSum {
    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        sumPrint(arr);
        optimalApproach(arr);
    }

    static void sumPrint(int[][] arr) {
        int sum = 0;
        // Primary Diagonal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                } else if (i + j == arr.length - 1) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.println(sum);
    }

    static void optimalApproach(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i] + arr[i][arr.length - 1 - i];

        }
        System.out.println(sum);
    }
}
