import java.util.*;
public class FractinalKnapsack {
    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int W = 50;

        double[][] ratio = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i]; 

        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = W;
        int totalValue = 0;

        for(int i = ratio.length - 1; i >= 0; i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){
                totalValue += value[idx];
                capacity -= weight[idx];
                System.out.println("Added Item " + idx + " with value " + value[idx]);
            } else {
                double fraction = (double) capacity / weight[idx];
                totalValue += value[idx] * fraction;
                System.out.println("Added " + fraction + " of Item " + idx + " with value " + (value[idx] * fraction));
                break;
            }
        }

        System.out.println("Total value in the knapsack: " + totalValue);

    }

    
}
