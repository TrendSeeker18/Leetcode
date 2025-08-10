class Solution {
    public int bs(int [] nums,int l,int h,int target){
        if(l>h) return -1;
        int mid=(l+h)/2;
        if(target==nums[mid]){
            return mid;
        }
        else if (target<nums[mid]){
            return bs(nums,l,mid-1,target);
        }
        else{
            return bs(nums,mid+1,h,target);
        }
    }
    public int search(int[] nums, int target) {
        return bs(nums,0,nums.length-1,target);
    }
}