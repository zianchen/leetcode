public class Solution {
    // https://discuss.leetcode.com/topic/5125/sharing-my-simple-c-code-o-n-time-o-1-space
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= maxleft) maxleft = height[left];
                else res += maxleft - height[left];
                left++;
            }
            else{
                if(height[right] >= maxright) maxright = height[right];
                else res += maxright - height[right];
                right--;
            }
        }
        return res;
    }
}