public class Solution {
    // 通用方法  https://discuss.leetcode.com/topic/7673/share-my-o-n-time-and-o-1-solution-when-duplicates-are-allowed-at-most-k-times
    public int removeDuplicates(int[] nums) {
        return allowK(nums, 2);
    }
    
    public int allowK (int[] nums, int k) {
        int n = nums.length;
        if (n <= k) return n;
        int update = 1, j = 1;
        int cnt = 1;
        while (j < n) {
            if (nums[j] != nums[j-1]) {
                cnt = 1;
                nums[update++] = nums[j];
            }
            else {
                if (cnt < k) {
                    nums[update++] = nums[j];
                    cnt++;
                }
            }
            ++j;
        }
        return update;
    }
}