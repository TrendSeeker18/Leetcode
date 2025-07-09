class Solution {
    public int minDistance(String word1, String word2) {
        int [][]dp=new int[word1.length()+1][word2.length()+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return solve(word1,word2,0,0,dp);
    }
    public int solve(String w1,String w2,int i,int j,int[][] dp){
        int ans=0;
        if(i==w1.length()) return w2.length()-j;
        if(j==w2.length()) return w1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            ans=solve(w1,w2,i+1,j+1,dp);
        }
        else{
            int insert=1+ solve(w1,w2,i,j+1,dp);
            int delete=1+solve(w1,w2,i+1,j,dp);
            int sub=1+ solve(w1,w2,i+1,j+1,dp);
            ans=Math.min(insert,Math.min(delete,sub));
        }
        dp[i][j]=ans;
        return ans;
    }
}