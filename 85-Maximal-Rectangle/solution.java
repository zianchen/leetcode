public class Solution {
    // 回头用这个解法再撸一遍 https://discuss.leetcode.com/topic/6650/share-my-dp-solution
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // init height[] for the first line
        int[] height = new int[matrix[0].length];
        for (int i = 0; i< height.length; i++) {
            if (matrix[0][i] == '1') {
                height[i]  = 1;
            }
        }
        int result = largestInLine(height);
        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        return result;
    }
    
    public void resetHeight(char[][] matrix, int[] height, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == '1') {
                height[j] += 1;
            // 不要忘了else
            } else {
                height[j] = 0;
            }
        }
    }
    // 单调递增栈
    public int largestInLine(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Deque<Integer> stk = new ArrayDeque();
        int maxArea = 0;
        // 注意，这里k 必须要取到 height.length
        for (int k = 0; k <= height.length; k++) {
            // 因为k有可能取到height.length，所以需要这一行
            int h = (k == height.length ? 0 : height[k]);
            if (stk.isEmpty() || h >= height[stk.peek()]) {
                stk.push(k);
            } else {
                int tp = stk.pop();
                maxArea = Math.max(maxArea, height[tp] * (stk.isEmpty() ? k : k - 1 - stk.peek()));
                // 世纪大遗漏！！如果进入了else,会出现k这个点被冒过去没有考虑的情况，所以要退回去在对这个k走一遍for循环
                k--;
            }
        }
        return maxArea;
    }
}