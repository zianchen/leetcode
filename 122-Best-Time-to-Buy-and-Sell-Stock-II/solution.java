public class Solution {
    public int maxProfit(int[] prices) {
        // in order to get profit as much as possible, and we could do as many transcation as possible, we just get every profit we could will be the max.
        // And since we will get zero profit if we do buy/sell multiple times at same day, this is meaningless.
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) {
                max += prices[i+1] - prices[i];
            }
        }
        return max;
    }
}