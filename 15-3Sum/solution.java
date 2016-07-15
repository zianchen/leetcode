public class Solution {
    
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum (i, nums);
        }
        return res;
    }
    
    public void twoSum (int i, int[] nums) {
        int left = i+1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                List<Integer> tmp = new ArrayList();
                tmp.add(nums[i]);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(tmp);
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}