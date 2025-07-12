class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int [n+1][2][k+1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int p = 0; p <= k; p++) {
                    dp[i][j][p] = -1;
                }
            }
        }
        return solve(prices,0,1,k,dp);
    }
    public int solve(int[] prices,int index,int buy,int limit,int [][][] dp){
        if(index==prices.length) return 0;
        if(limit==0) return 0;
        if(dp[index][buy][limit]!=-1) return dp[index][buy][limit];
        int ans=0;
        if(buy==1){
            ans=Math.max(-prices[index]+solve(prices,index+1,0,limit,dp),solve(prices,index+1,1,limit,dp));
        }
        else{
            ans=Math.max(prices[index]+solve(prices,index+1,1,limit-1,dp),solve(prices,index+1,0,limit,dp));
        }
        dp[index][buy][limit]=ans;
        return dp[index][buy][limit];
    }
}