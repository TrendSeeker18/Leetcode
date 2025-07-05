class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int a = matrix.length;
        int[][] dp = new int[a][a];

        for (int i = 0; i < a; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < a; i++) {
            for (int j = 0; j < a; j++) {
                int b = matrix[i][j] + dp[i - 1][j];
                int c = Integer.MAX_VALUE;
                int d = Integer.MAX_VALUE;

                if (j > 0) {
                    c = matrix[i][j] + dp[i - 1][j - 1];
                }
                if (j < a - 1) {
                    d = matrix[i][j] + dp[i - 1][j + 1];
                }

                int x = Math.min(b, c);
                dp[i][j] = Math.min(x, d);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < a; j++) {
            ans = Math.min(ans, dp[a - 1][j]);
        }
        return ans;
    }
}
