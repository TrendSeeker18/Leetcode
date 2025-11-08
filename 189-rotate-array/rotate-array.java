class Solution {
    public void p(int [] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        p(nums,0,nums.length-1);
        p(nums,0,k-1);
        p(nums,k,nums.length-1);
        
    }
}