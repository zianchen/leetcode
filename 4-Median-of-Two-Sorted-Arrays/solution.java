public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    public double findKth(int[] A, int start_A, int[] B, int start_B, int k) {
        if (start_A >= A.length) {
            return B[start_B + k - 1];
        } 
        if (start_B >= B.length) {
            return A[start_A + k - 1];
        }
        if (k == 1) {
            return Math.min(A[start_A], B[start_B]);
        }
        
        int key_A = start_A + k / 2 - 1 < A.length ? A[start_A + k / 2 - 1] : Integer.MAX_VALUE;  
        int key_B = start_B + k / 2 - 1 < B.length ? B[start_B + k / 2 - 1] : Integer.MAX_VALUE;
        if (key_A < key_B) {
            return findKth(A, start_A + k / 2, B, start_B, k - k / 2);
        } else {
            return findKth(A, start_A, B, start_B + k / 2, k - k / 2);
        }
    }
}