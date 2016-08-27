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
        generatePath(root, "");
        return res;
    }

    private void generatePath(TreeNode node, String str) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(str + node.val);
            return;
        }
        generatePath(node.left, str + node.val + "->");
        generatePath(node.right, str + node.val + "->");
    }
}