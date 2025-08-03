class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros=0;
        int max=0;
        int start=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeros++;
                
            }
            while(zeros>k){
                if(nums[start]==0){
                    zeros--;
                }
                start++;
            }
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}