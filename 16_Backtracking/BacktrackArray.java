
public class BacktrackArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArray(arr, 0, 1);
        printArr(arr);

    }

    public static void changeArray(int[] arr, int i, int v) {
       //base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        //recursion
        arr[i]=v;
        changeArray(arr, i + 1, v + 1);//function call
        arr[i]=arr[i]-2; //backtracking step

    }


    //noraml function print arr;
    public static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
