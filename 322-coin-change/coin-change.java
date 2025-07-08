class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp=new int[n+1][amount+1];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        int a= solve(coins,0,amount,dp);
        return a==Integer.MAX_VALUE-1?-1:a;
    }
    public int solve(int[] coins,int index,int amount,int [][] dp){
        if(index==coins.length) return amount==0?0:Integer.MAX_VALUE - 1;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int include=Integer.MAX_VALUE - 1;
        if (coins[index] <= amount) {
        int res = solve(coins, index, amount - coins[index], dp);
        if (res != Integer.MAX_VALUE - 1)
            include = 1 + res;
        }

        int exclude=solve(coins,index+1,amount,dp);
        return dp[index][amount]=Math.min(include,exclude);
    }
}