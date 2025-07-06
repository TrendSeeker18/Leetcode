import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        // Use Boolean[][] for memoization (null check support)
        Boolean[][] dp = new Boolean[n+1][target + 1];

        return sum(nums, 0, target, dp);
    }

    public boolean sum(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (index == nums.length) return false;

        if (dp[index][target] != null) return dp[index][target];

        boolean include = false;
        if (nums[index] <= target) {
            include = sum(nums, index + 1, target - nums[index], dp);
        }

        boolean exclude = sum(nums, index + 1, target, dp);

        return dp[index][target] = include || exclude;
    }
}
