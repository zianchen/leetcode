public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        for (int i = 0; i <= nums.length; i++) {
            int start = i == 0 ? lower : nums[i-1] + 1;
            int end = i == nums.length ? upper : nums[i] - 1;
            addMissing(result, start, end);
        }
        return result;
    }
    public void addMissing(List<String> result, int start, int end) {
        if (end < start) {
            return;
        }
        if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }
    }
}