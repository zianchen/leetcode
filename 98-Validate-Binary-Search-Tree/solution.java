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
    
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        return validHelper(root);
    }

    private boolean validHelper(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!validHelper(node.left)) return false;
        if (prev != null && prev.val >= node.val) return false;
        prev = node;
        return validHelper(node.right);
    }
}