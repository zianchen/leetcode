public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        return removeDuplicatesAtMostK(nums, len, 2);
    }
    /*
    I think both Remove Duplicates from Sorted Array I and II could be solved in a consistent and more general way by allowing the duplicates to appear k times (k = 1 for problem I and k = 2 for problem II).
    */
    public int removeDuplicatesAtMostK(int[] nums, int len, int k) {
        int l = 1, r = 1; 
        int countLeft = 1;
        while (r < nums.length) {
            if (nums[r] == nums[r-1]) {
                if (countLeft < 2) {
                    nums[l++] = nums[r];
                    countLeft++;
                }
            } else {
                nums[l++] = nums[r];
                countLeft = 1;
            }
            r++;
        }
        return l;
    }
}