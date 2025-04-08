package Arrays_02;

public class BuySellStock {
    public static void main(String[] args) {
        int price[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(approach(price));

    }

    public static int approach(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;// today's profit
                maxProfit = Math.max(maxProfit, profit);

            } else {
                buyPrice = price[i];
            }
        }

        return maxProfit;
    }
}
