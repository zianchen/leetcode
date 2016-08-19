public class Solution {
    public boolean isMatch(String s, String p) {
        //sanity check
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        // dp[i][j] represent if s[0..i-1] matchs p[0..j-1].
        dp[0][0] = true;
        // 这个corner case非常绕，// p[0.., j - 3, j - 2, j - 1] matches empty iff p[j - 1] is '*' and p[0..j - 3] matches empty。j-2不用管因为无论j-2是什么，j-1 == '*' 都可以用0个j-2把j-2删掉。
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 1 && p.charAt(j-1) == '*' && dp[0][j-2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) != '.' && p.charAt(j-1) != '*') {
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                } else if (p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    if (j > 1) {
                        // * match zero or one preceding.
                        if (dp[i][j-2] || dp[i][j-1]) {
                            dp[i][j] = true;
                        } else if ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.' ) && dp[i-1][j]) {  //|| p.charAt(j-2) == '.'非常容易漏掉
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}