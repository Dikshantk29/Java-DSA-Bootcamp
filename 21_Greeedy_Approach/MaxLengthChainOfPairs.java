import java.util.Arrays;
import java.util.Comparator;

class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {15, 25}, {27, 40}, {50, 60}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int ans = 1;
        int chainLength = 1;
        int pairEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > pairEnd) {
                chainLength++;
                pairEnd = pairs[i][1];  
            }
        }
        System.out.println("chainLength: " + chainLength);

    }
}