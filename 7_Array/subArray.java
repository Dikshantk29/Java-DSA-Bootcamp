public class subArray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        printSubArray(arr);
    }

    static void printSubArray(int[] arr) {
        int sum = 0;
        int Minsum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int eachSum=0;
                for (int k = start; k <= end; k++) {
                    eachSum += arr[k];
                    if (eachSum > sum) {
                        sum = eachSum;
    
                    }
                    if(eachSum < Minsum){
                        Minsum = eachSum;
                    }
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("max sum is :"+sum);
        System.out.println("min sum is :"+Minsum);
    }
}