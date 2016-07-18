public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j == k-1) {
                return nums[j];
            } else if (j < k-1) {
                lo = j+1;
            } else {
                hi = j-1;
            }
        }
        return nums[k-1];
    }
    
    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int boundary = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, boundary);
                boundary++;
            }
        }
        swap(nums, hi, boundary);
        return boundary;
    }
    
    public void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}