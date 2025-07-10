import java.util.HashMap;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1]; // dp[i][j] stores result for s[0..i-1], p[0..j-1]
        return solve(s, p, n - 1, m - 1, dp);
    }

    public boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        // Base cases
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        // Check memo table
        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            dp[i][j] = solve(s, p, i - 1, j, dp) || solve(s, p, i, j - 1, dp);
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
}
