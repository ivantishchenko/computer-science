class Solution {
    public int maxProfitBrute(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
         }
        return profit;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }
}