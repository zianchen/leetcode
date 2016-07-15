public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == s ? 1 : 0;
        }
        int left = 0, right = 1;
        // int min = Integer.MAX_VALUE;
        int tmp = nums[left];
        int len = Integer.MAX_VALUE;
        while (right < nums.length) {
            while (right < nums.length && tmp < s) {
                tmp += nums[right];
                right++;
            }
            while (tmp >= s) {
                //min = Math.min(min, tmp);
                len = Math.min(len, right - left);
                tmp -= nums[left];
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}