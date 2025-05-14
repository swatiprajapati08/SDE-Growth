class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        int i = 0, j = 0;

        for (int k = 0; k < haystack.length(); k++) {
            i = k;
            j = 0;
            if (haystack.charAt(k) == needle.charAt(j)) {
                while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }

                if (j == needle.length()) {
                    index = i - needle.length();
                    return index; // first occurance
                }
            }
        }
        return index;
    }
}