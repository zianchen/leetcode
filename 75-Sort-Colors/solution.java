public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p1 = 0, cur = 0, p2 = nums.length - 1;
        while(cur <= p2) {
            if (nums[cur] == 0) {
                swap(cur, p1, nums);
                p1++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(cur, p2, nums);
                p2--;
            }
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}