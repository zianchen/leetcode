public class Solution {
    public int numWays(int n, int k) {
        //sannity check
        if (n == 0 || k == 0) {
            return 0;
        }
        // pan attention for case n == 1
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n];
        // dp[i] represent how many choices for 0 - i-1th fence.
        dp[0] = k;
        dp[1] = k*k;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1);
        }
        return dp[n-1];
    }
}