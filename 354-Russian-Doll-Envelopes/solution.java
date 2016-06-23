public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        /*
        1. use compare to sort the array
        2. use find longest increasing sequence
        */
        // sannity check
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];  // becaue we want to calculate logest increasing sequence on right index, it will mess up if we still sort elements in acending order when left index are equal.
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        // since left index is strictly increasing, we only need to consider right index.
        /*  这个方法是错的，sequence是可以不连续的，下面这个做法求的是longest increasing subarray。
        int start = 0, maxLen = 0;
        for (int i = 1; i < envelopes.length; i++) {
            // if (envelopes[i][1] > envelopes[start][1]) {  注意这里不是 > start,而是比前一个大，也就是i-1.
            if (envelopes[i][1] > envelopes[i-1][1]) { 
                continue;
            } else {
                maxLen = Math.max(maxLen, i - start);
                start = i;
            }
        }
        maxLen = Math.max(maxLen, envelopes.length - start);
        return maxLen;
        */
        int n = envelopes.length;
        int[] rightIndexArr = new int[n];
        for (int i = 0; i < n; i++) {
            rightIndexArr[i] = envelopes[i][1];
        }
        int ret = lengthOfLIS(rightIndexArr);
        return ret;
    }
    
    public int lengthOfLIS(int[] nums) {
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