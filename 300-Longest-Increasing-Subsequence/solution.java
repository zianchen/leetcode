public class Solution {
    public int lengthOfLIS(int[] nums) {
        // O(n^2) dp
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        // dp[i] 不表示 nums.length == i 的时候原问题的解，而表示的是subsequence一定以i作为结尾时，原问题在nums.length == i 的时候的解
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}