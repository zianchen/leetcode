public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] targetHash = new int[256];
        int[] sourceHash = new int[256];
        
        initialTargetHash(targetHash, t);
        int left = 0, right = 0;
        int globalMin = Integer.MAX_VALUE;
        String res = "";
        while(right < s.length()) {
            while (right < s.length() && !isValid(sourceHash,targetHash)) {
                sourceHash[s.charAt(right)]++;
                right++;
            }
            while (isValid(sourceHash, targetHash)) {
                int localMin = right - left;
                if (localMin < globalMin) {
                    globalMin = localMin;
                    res = s.substring(left, right);
                }
                sourceHash[s.charAt(left)]--;
                left++;
            }
        }
        return res;
    }
    public void initialTargetHash(int[] targetHash, String t) {
        for (int i = 0; i < t.length(); i++) {
            targetHash[t.charAt(i)]++;
        }
    }
    public boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < targetHash.length; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }
}