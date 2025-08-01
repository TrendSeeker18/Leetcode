import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0, max = 0;
        int duplicateCount = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 2) {
                duplicateCount++;
            }
        }
        if (duplicateCount == 0) max = sum;

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int freqOut = map.get(out);
            if (freqOut == 2) duplicateCount--;  // frequency will reduce from 2 to 1
            map.put(out, freqOut - 1);
            if (map.get(out) == 0) map.remove(out);
            sum -= out;

            int in = nums[i];
            map.put(in, map.getOrDefault(in, 0) + 1);
            if (map.get(in) == 2) duplicateCount++; // frequency increased from 1 to 2
            sum += in;

            if (duplicateCount == 0) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
