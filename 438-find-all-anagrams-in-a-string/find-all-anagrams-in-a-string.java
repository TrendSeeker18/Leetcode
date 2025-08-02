import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count each letter in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        // Sliding window
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;    // include right character

            // Remove left character when window size > p.size
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // If arrays are equal, it's an anagram's start
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
