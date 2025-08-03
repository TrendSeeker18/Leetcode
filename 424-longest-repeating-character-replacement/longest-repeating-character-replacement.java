class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int start=0;
        int [] l=new int[256];
        int maxcnt=0;
        int maxlength=0;
        for(int i=0;i<n;i++){
            l[s.charAt(i)-'A']++;
            maxcnt=Math.max(maxcnt,l[s.charAt(i)-'A']);
            int windowlength=i-start+1;
            while(windowlength - maxcnt >k){
                l[s.charAt(start)-'A']--;
                start++;
                windowlength = i - start + 1;
            }
            maxlength=Math.max(maxlength,windowlength);
        }
        return maxlength;
    }
}