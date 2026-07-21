class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // Optimization for large k
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // buy[t] = max profit with at most t transactions, currently holding a stock
        // sell[t] = max profit with at most t transactions, NOT holding a stock
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initialize buy values to -Infinity since buying costs money upfront
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int t = 1; t <= k; t++) {
                // Choice for buy: Keep previous buy OR buy at current price using profit from (t-1) sells
                buy[t] = Math.max(buy[t], sell[t - 1] - price);
                
                // Choice for sell: Keep previous sell OR sell current stock at price
                sell[t] = Math.max(sell[t], buy[t] + price);
            }
        }

        return sell[k];
    }
}