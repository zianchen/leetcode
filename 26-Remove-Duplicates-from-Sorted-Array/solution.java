public class Solution {
    // 不断地用后面的元素顶上去覆盖duplicate的元素，id记录当前可覆盖的位置
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int id = 1;
        for(int i = 1; i < n; ++i) {
           if(nums[i] != nums[i-1]) {
                nums[id++] = nums[i];       
           }
        }
        return id;
    }
}