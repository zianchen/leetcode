public class Solution {
    
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, visited);
        return res;
    }

    private void dfs(int[] input, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == input.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(input[i]);
                dfs(input, tmp, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
                while (i < input.length - 1 && input[i] == input[i+1]) {
                    i++;
                }
            }
        }
    }
}