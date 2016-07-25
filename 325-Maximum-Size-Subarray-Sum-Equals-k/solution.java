public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        /*
        The HashMap stores the sum of all elements before index i as key, and i as value. For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k, and update max length.
        */
        Map<Integer,Integer> map = new HashMap();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = i + 1;
            // } else if (map.containsKey(k - sum)) {    蠢哭了，这里不是k - sum,是sum - k!!! 因为是sum[i] - sum[prev],这里prev = map.get(k - sum)
                // maxLen = Math.max(maxLen, i - map.get(k - sum));
            } else if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}