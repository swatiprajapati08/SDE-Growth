class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0, j = 0, res = 0, maxCount = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            freq[ch - 'A']++;
            maxCount = Math.max(maxCount, freq[ch - 'A']);

            if (j - i + 1 - maxCount > k) {
                // means i cant replace shink the window
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}