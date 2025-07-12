class Solution {
    Long dp[][][];
    long maxProfit(int nums[],int i,int k,int hold){
        int n = nums.length;
        if(i==n && hold!=0) return Integer.MIN_VALUE;
        if(i>=n || k==0) return 0;
        if(dp[i][k][hold]!=null) return dp[i][k][hold];
        long ans=Long.MIN_VALUE/10;
        if(hold==0){
            long skip = maxProfit(nums,i+1,k,0);
            long buy =  -nums[i] + maxProfit(nums,i+1,k,1);
            long shortsell =  nums[i] + maxProfit(nums,i+1,k,2);
            ans = Math.max(skip,Math.max(buy,shortsell));
        }
        else if(hold==1){
            long keep = maxProfit(nums,i+1,k,1);
            long lelo = nums[i] + maxProfit(nums,i+1,k-1,0);
            ans = Math.max(keep,lelo);
        }
        else if(hold==2){
            long keep = maxProfit(nums,i+1,k,2);
            long buy = -nums[i] + maxProfit(nums,i+1,k-1,0) ;
            ans = Math.max(keep,buy);
        }
        return dp[i][k][hold] = ans;
    }
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new Long[n][k+1][3];
        return maxProfit(prices,0,k,0);
    }
}