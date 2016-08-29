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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        generatePath(root, sb);
        return res;
    }

    private void generatePath(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        int len = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
            // return; 
        }
        sb.append("->");
        generatePath(node.left, sb);
        generatePath(node.right, sb);
        sb.setLength(len);
    }
}