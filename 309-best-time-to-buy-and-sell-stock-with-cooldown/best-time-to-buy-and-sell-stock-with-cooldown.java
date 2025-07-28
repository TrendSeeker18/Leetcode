class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][] dp=new int[n+1][2];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,dp,0,1);
    }
    private int solve(int[] prices,int [][] dp,int idx,int buy){
        if(idx>=prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[idx]+solve(prices,dp,idx+1,0),solve(prices,dp,idx+1,1));
        }
        else{
            profit=Math.max(prices[idx]+solve(prices,dp,idx+2,1),solve(prices,dp,idx+1,0));
        }
        return dp[idx][buy]=profit;
    }
}