class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=new StringBuilder(s).reverse().toString();
        int [][] dp=new int[s.length()+1][s1.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(s,s1,dp,0,0);
    }
    public int solve(String s,String s1,int [][]dp,int i,int j){
        int ans=0;
        if(i==s.length()|| j==s1.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s1.charAt(j)){
            ans= 1+solve(s,s1,dp,i+1,j+1);
        }
        else{
            ans= Math.max(solve(s,s1,dp,i+1,j),solve(s,s1,dp,i,j+1));
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
}