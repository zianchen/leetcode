public class Solution {
    // https://discuss.leetcode.com/topic/23399/standard-binary-search
    // https://segmentfault.com/a/1190000003794831
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if (citations[mid] == (len - mid)) {
                return citations[mid];  
            } else if (citations[mid] > (len - mid)) {
                right = mid - 1;    
            } else {
                left = mid + 1;    
            }
        }
        return len - (right + 1);
    }
}