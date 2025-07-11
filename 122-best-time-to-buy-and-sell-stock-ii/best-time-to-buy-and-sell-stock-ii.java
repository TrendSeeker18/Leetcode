class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0,1,dp,prices);
    }
    public int solve(int i,int buy,int[][] dp,int[] prices){
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,dp,prices),solve(i+1,1,dp,prices));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,1,dp,prices),solve(i+1,0,dp,prices));
        }
        dp[i][buy] = profit;
        return dp[i][buy];  // ✅ VALID: you're returning the stored result

    }
}