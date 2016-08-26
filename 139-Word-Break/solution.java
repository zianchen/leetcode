public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}