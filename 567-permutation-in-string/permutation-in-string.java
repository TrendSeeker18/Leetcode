import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] pcount = new int[26];
        int[] scount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            pcount[s1.charAt(i) - 'a']++;
            scount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pcount, scount)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            scount[s2.charAt(i) - 'a']++; // include right char
            scount[s2.charAt(i - s1.length()) - 'a']--; // remove left char

            if (Arrays.equals(pcount, scount)) return true;
        }
        return false;
    }
}
