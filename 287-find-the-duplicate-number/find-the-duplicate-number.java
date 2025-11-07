class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int n=nums.length;
        int a=0;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])){
                a=nums[i];
            }
            set.add(nums[i]);
        }
        return a;
    }
}