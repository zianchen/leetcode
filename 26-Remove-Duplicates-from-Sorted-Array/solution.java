public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int l = 1, r = 1, len = nums.length;
        while (r < nums.length) {
            if (nums[r] == nums[r-1]) {
                len--;
            } else {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return len;
    }
}