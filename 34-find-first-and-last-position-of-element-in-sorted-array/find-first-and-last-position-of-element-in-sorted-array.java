class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] l= {-1,-1};
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(target==nums[mid]){
                l[0]=mid;
                high=mid-1;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(l[0]==-1) return l;
        low=l[0];
        high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(target==nums[mid]){
                l[1]=mid;
                low=mid+1;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return l;
    }
}