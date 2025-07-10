class Solution {
    public int minInsertions(String s) {
        int [][] dp=new int [s.length()+1][s.length()+1];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(s,0,s.length()-1,dp);
    }
    public int solve(String s,int i,int j,int[][] dp){
        if (i >= j) return 0;
        if (i == s.length() || j == s.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]= solve(s,i+1,j-1,dp);
        }
        else{
            int insertLeft = 1 + solve(s, i + 1, j, dp);
            int insertRight = 1 + solve(s, i, j - 1, dp);
            dp[i][j] = Math.min(insertLeft, insertRight);
        }
        return dp[i][j];
    }
}