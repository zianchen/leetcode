public class Solution {
    
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
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
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}