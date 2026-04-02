class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int i = 0, j = 0, res = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (hs.containsKey(ch)) {
                char ch1 = s.charAt(i);
                // remove from the Hashmap and increment the i
                int val = hs.get(ch1);
                if (val == 1)
                    hs.remove(ch1);
                else
                    hs.put(ch1, val - 1);
                i++;
            } else {
                hs.put(ch, hs.getOrDefault(ch, 0) + 1);
                res = Math.max(res, j - i + 1);
                j++;
            }
        }
        return res;
    }
}