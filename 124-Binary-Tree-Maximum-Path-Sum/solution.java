/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathDown(root);
        return max;
    }
    
    //思路见注解
    public int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        int right  = Math.max(0, maxPathDown(node.right));
        max = Math.max(max, left + node.val + right);
        return Math.max(left, right) + node.val;
    }
}