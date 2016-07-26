public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        // 注意，n == first和second的时候，也要更新，而不仅仅是<的时候才更新，否则最后一个else就成了只要n>= first && n >= second,就算找到第三大的数了，对于  1,1,1,1,1 这样的case就不对了
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first) {   
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }
}