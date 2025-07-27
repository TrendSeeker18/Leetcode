class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        // 4D DP array to memoize states: dp[r1][c1][r2][c2]
        Integer[][][][] dp = new Integer[N][N][N][N];

        // Start both persons at (0,0)
        return Math.max(0, cherryPickup(grid, N, 0, 0, 0, 0, dp));
    }

    private int cherryPickup(int[][] grid, int n, int r1, int c1, int r2, int c2, Integer[][][][] dp) {
        // Derive c2 if you want: c2 = r1 + c1 - r2 (optional optimization),
        // but here both c1,c2 passed explicitly.

        // Base case: Out of grid or thorn cell
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n
            || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // If both reach bottom-right cell
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];  // must be same cell for both at end

        // Check if this subproblem was already solved
        if (dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];

        int cherries = 0;

        // If both persons are on the same cell, count cherry only once
        if (r1 == r2 && c1 == c2)
            cherries = grid[r1][c1];
        else
            cherries = grid[r1][c1] + grid[r2][c2];

        // Explore all next move combinations for both persons:
        // person1 moves: down or right; person2 moves: down or right
        int nextMax = Math.max(
            Math.max(cherryPickup(grid, n, r1 + 1, c1, r2 + 1, c2, dp),
                     cherryPickup(grid, n, r1 + 1, c1, r2, c2 + 1, dp)),
            Math.max(cherryPickup(grid, n, r1, c1 + 1, r2 + 1, c2, dp),
                     cherryPickup(grid, n, r1, c1 + 1, r2, c2 + 1, dp))
        );

        cherries += nextMax;

        // Memoize and return result for this state
        dp[r1][c1][r2][c2] = cherries;
        return cherries;
    }
}
