public class Solution {
    // 可以背下来的解法   http://blog.csdn.net/u011095253/article/details/9158397
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> tmp = new ArrayList();
        res.add(tmp);
        dfs(nums, tmp, 0);
        return res;
    }
    
    public void dfs(int[] nums, List<Integer> tmp, int idx) {
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList(tmp));
            dfs(nums, tmp, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}