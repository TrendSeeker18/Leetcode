import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        // If absolute target > sum, it's not possible
        if (Math.abs(target) > sum) return 0;

        // Initialize memo table with -1 (not computed)
        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return sem(nums, 0, 0, target, dp, sum);
    }

    public int sem(int[] nums, int index, int currSum, int target, int[][] dp, int offset) {
        if (index == nums.length) {
            return currSum == target ? 1 : 0;
        }

        if (dp[index][currSum + offset] != -1) {
            return dp[index][currSum + offset];
        }

        int add = sem(nums, index + 1, currSum + nums[index], target, dp, offset);
        int subtract = sem(nums, index + 1, currSum - nums[index], target, dp, offset);

        dp[index][currSum + offset] = add + subtract;
        return dp[index][currSum + offset];
    }
}
