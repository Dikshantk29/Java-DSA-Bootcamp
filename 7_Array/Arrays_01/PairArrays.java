package Arrays_01;
public class PairArrays {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 7, 8, 9, 10 };
        int count = 0;
        printPaisrs(arr, count);
        
    }

    static void printPaisrs(int[] arr, int count) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + curr + "," + arr[j] + ")" + " ");
                count++;
            }
            System.out.println();
        }
        System.out.println("Total pairs: " + count);

    }
}
