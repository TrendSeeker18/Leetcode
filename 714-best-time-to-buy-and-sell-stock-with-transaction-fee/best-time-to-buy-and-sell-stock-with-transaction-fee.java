class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2]; // dp[i][buy]
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(prices, 0, 1, fee, dp);
    }

    public int solve(int[] prices, int i, int buy, int fee, int[][] dp) {
        if (i == prices.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];

        int profit;
        if (buy == 1) {
            profit = Math.max(
                -prices[i] + solve(prices, i + 1, 0, fee, dp),  // buy
                solve(prices, i + 1, 1, fee, dp)                // skip
            );
        } else {
            profit = Math.max(
                prices[i] - fee + solve(prices, i + 1, 1, fee, dp),  // sell
                solve(prices, i + 1, 0, fee, dp)                     // skip
            );
        }

        dp[i][buy] = profit;
        return profit;
    }
}
