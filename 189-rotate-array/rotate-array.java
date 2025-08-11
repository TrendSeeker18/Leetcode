class Solution {
    public void rev(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length; // handle k > length
        rev(nums, 0, nums.length - 1); // reverse entire array
        rev(nums, 0, k - 1);           // reverse first k elements
        rev(nums, k, nums.length - 1); // reverse remaining elements
    }
}
