public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // no special sanity check since n is non-negative
        /*
        dp[i] represent count of number with unique digits of length i.
        dp[0] = 0;
        dp[1] = 10;
        dp[2] = 9*9;
        dp[3] = 9*9*8;
        dp[4] = 9*9*8*7;
        ...
        dp[10] = 9*9*8*7*6*5*4*3*2*1;
        any n > 10 will have no distinct integers.
        */
        if (n == 0) {
            return 1;
        }
        int count = 9, numOfChoice = 9;
        int ret = 10;
        int i = 1;
        while (i < n && numOfChoice > 0) {
            count *= numOfChoice;
            ret += count;
            numOfChoice--;
            i++;
        }
        return ret;
    }
}