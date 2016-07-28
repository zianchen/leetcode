/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // level order traversal
        if (root == null) {
            return;
        }
        while (root != null) {
            TreeLinkNode levelDummy = new TreeLinkNode(0);
            TreeLinkNode levelCurr = levelDummy;
            while (root != null) {
                if (root.left != null) {
                    levelCurr.next = root.left;
                    levelCurr = levelCurr.next;
                }
                if (root.right != null) {
                    levelCurr.next = root.right;
                    levelCurr = levelCurr.next;
                }
                root = root.next;
            }
            root = levelDummy.next;
        }
    }
}