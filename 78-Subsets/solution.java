public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        res.add(tmp);
        helper(tmp, 0, nums);
        return res;
    }

    private void helper(List<Integer> tmp, int idx, int[] nums) {
        for (int i = idx; i < nums.length; i++) {
//            tmp.add(nums[idx]);  巨型bug,不是nums[idx],而是nums[i]
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
//            helper(tmp, idx +1, nums);
            helper(tmp, i+1, nums);
            tmp.remove(tmp.size()-1);
        }
    }
}