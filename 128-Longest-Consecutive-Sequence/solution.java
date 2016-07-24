public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap();
        int globalMax = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int sum = left + 1 + right;
                map.put(n, sum);
                
                // update globalMax
                globalMax = Math.max(globalMax, sum);
                
                // update new length to the boundary of the sequence that contains n
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        return globalMax;
    }
}