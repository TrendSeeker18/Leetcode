class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(text1,text2,0,0,dp);

    }
    public int solve(String t1,String t2,int i,int j,int [][]dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==t1.length() || j==t2.length()) return 0;
        int ans=0;
        if(t1.charAt(i)==t2.charAt(j)){
            ans= 1+solve(t1,t2,i+1,j+1,dp);
        }
        else{
            ans=Math.max(solve(t1,t2,i,j+1,dp),solve(t1,t2,i+1,j,dp));
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
}