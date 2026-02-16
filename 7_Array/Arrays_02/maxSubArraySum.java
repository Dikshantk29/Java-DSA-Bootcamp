package Arrays_02;
public class maxSubArraySum {

    public static void main(String[] args) {
        int[] arr = { -1, -2, -3, -4, -5 };
         maxSubarray(arr);
         PrefixSumApproach(arr);
         KadanesAlgorithm(arr);
    }

    static void maxSubarray(int[] arr) {
        // max Subarray Sum-1
        // t(O(n^3))
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                System.out.println(currSum);

                if (currSum > maxSum) {
                    maxSum = currSum;
                }

            }
        }
        System.out.println("max sum of subarray: " + maxSum);

    }

    static void PrefixSumApproach(int[] arr) {
        // max Subarray Sum
        // prefixSum approach

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE; // Start with smallest possible value instead of 0
        int currSum;

        for (int i = 0; i < arr.length; i++) {
            int start = i;

            for (int j = i; j < arr.length; j++) {
                int end = j;

                // Calculate current sum correctly
                if (start == 0) {
                    currSum = prefix[end];
                } else {
                    currSum = prefix[end] - prefix[start - 1];
                }

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum of subarray: " + maxSum);
    }

    static void KadanesAlgorithm(int[] arr) {
        // max Subarray Sum
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to running sum
            currSum += arr[i];

            // Update maxSum if currSum is larger
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            // If currSum becomes negative, reset it to 0
            // (meaning we're better off starting a new subarray)
            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println("max sum of subarray: " + maxSum);
    }

}
