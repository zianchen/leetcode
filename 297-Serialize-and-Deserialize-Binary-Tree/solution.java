/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private String NN = "null";
    private String spliter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    public void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        TreeNode root = buildTree(nodes);
        return root;
    }
    public TreeNode buildTree(Deque<String> nodes) {
        String cur = nodes.removeFirst();
        if (cur.equals(NN)) {
            return null;
        } 
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = buildTree(nodes);    //注意，这里不是TreeNode node.left = ...而是直接node.left = ...，因为在new node的时候，node.left和node.right已经new出来了.
        node.right = buildTree(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));