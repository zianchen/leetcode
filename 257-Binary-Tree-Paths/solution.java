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
    private List<String> res = new ArrayList(); 
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return res;
    }
    
    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        if (sb.length() >= 1) {
            sb.append("->");    
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.setLength(len);
    }
}