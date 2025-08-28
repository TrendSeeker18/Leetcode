class Solution {
    public int[] numberOfPairs(int[] nums) {
        int []fr=new int[101];
        for(int i:nums){
            fr[i]++;
        }
        int pair=0;
        for(int i=0;i<101;i++){
            pair+=fr[i]/2;
        }
        return new int[]{pair,nums.length-2*pair};
    }
}