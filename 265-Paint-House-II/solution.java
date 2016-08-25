public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        
        //dp[j] means the min cost for color j (from 0-i, since we traverse i from 0 to n, no need to maintain dp[i][j], just dp[j] is ok)
        int[] dp = new int[k];
        // min1 means first minimum cost, min2 means second minimum cost
        int min1 = 0, min2 = 0;

        for (int i = 0; i < n; i++) {
            int oldMin1 = min1;
            int oldMin2 = min2;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            
            for (int j = 0; j < k; j++) {
                if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
                    dp[j] = oldMin1 + costs[i][j];
                } else {
                    dp[j] = oldMin2 + costs[i][j];
                }
                
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }
        }
        return min1;
    }
}