import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sec = target - nums[i];
            if (map.containsKey(sec)) {
                return new int[]{map.get(sec), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
