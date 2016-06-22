public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // sliding window
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> cMap = new HashMap();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // add in map
            char c = s.charAt(i);
            if (cMap.containsKey(c)) {
                cMap.put(c, cMap.get(c)+1);
            } else {
                cMap.put(c, 1);
            }
            //check if size > k
            while (cMap.size() > k) {
                char first = s.charAt(start);
                cMap.put(first, cMap.get(first) - 1);
                int count = cMap.get(first);
                if (count == 0) {
                    cMap.remove(s.charAt(start));
                }
                start++;
            }
            maxLen = Math.max(maxLen, (i - start + 1));
        }
        return maxLen;
    }
}