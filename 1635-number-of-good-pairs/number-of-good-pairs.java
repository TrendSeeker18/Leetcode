class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(h.containsKey(nums[i])){
                cnt+=h.getOrDefault(nums[i], 0);
                
            }
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);

        }
        return cnt;
    }
}