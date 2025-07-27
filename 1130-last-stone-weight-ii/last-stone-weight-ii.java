class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        
        int n = stones.length;
        // dp[i][j] = whether it's possible to get sum j using stones from index i onward
        Boolean[][] dp = new Boolean[n][sum + 1];
        
        int closestSum = findClosestSum(stones, 0, 0, dp, sum / 2);
        int otherSum = sum - closestSum;
        return Math.abs(otherSum - closestSum);
    }
    
    private int findClosestSum(int[] stones, int index, int currentSum, Boolean[][] dp, int target) {
        if (index == stones.length) {
            // reached end, return current sum
            return currentSum;
        }
        
        if (dp[index][currentSum] != null) {  // memo check to skip recomputation
            return dp[index][currentSum] ? currentSum : Integer.MIN_VALUE;
        }
        
        int include = Integer.MIN_VALUE;
        if (currentSum + stones[index] <= target) {
            include = findClosestSum(stones, index + 1, currentSum + stones[index], dp, target);
        }
        int exclude = findClosestSum(stones, index + 1, currentSum, dp, target);
        
        // Take the max sum achievable closest to target
        int result = Math.max(include, exclude);
        
        dp[index][currentSum] = (result != Integer.MIN_VALUE);
        return result;
    }
}
