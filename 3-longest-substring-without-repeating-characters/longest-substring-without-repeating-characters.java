class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] charCount = new int[256]; // For general ASCII characters
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < n; end++) {
            char charAtEnd = s.charAt(end);
            charCount[charAtEnd]++;

            while (charCount[charAtEnd] > 1) {
                char charAtStart = s.charAt(start);
                charCount[charAtStart]--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}