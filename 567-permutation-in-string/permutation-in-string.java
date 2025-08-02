class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1cnt[]=new int[26];
        int s2cnt[] =new int [26];
        for(int i=0;i<s1.length();i++){
            s1cnt[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            s2cnt[s2.charAt(i)-'a']++;
            if(i>=s1.length()){
                s2cnt[s2.charAt(i-s1.length())-'a']--;
            }
            if(Arrays.equals(s1cnt,s2cnt)){
                return true;
            }
        }
        return false;
    }
}