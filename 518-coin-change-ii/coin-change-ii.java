class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][] dp=new int[n+1][amount+1];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(coins,0,amount,dp);
        
    }
    public int solve(int[] coins,int index,int amount,int [][] dp){
        if(index==coins.length) return amount==0? 1:0;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int include=0;
        if (coins[index] <= amount) {
            include= solve(coins, index, amount - coins[index], dp);
        }

        int exclude=solve(coins,index+1,amount,dp);
        return dp[index][amount]=include+exclude;

    }
}