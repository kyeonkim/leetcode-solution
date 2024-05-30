/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode findNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode = null;
        dfs(root, p, q);
        return findNode;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int rootValue = 0;
        if (root.val == p.val)
            rootValue = 1;
        else if (root.val == q.val)
            rootValue = 2;
        int value = left | right | rootValue;
        if (value == 3) {
            findNode = root;
            return 0;
        } else {
            return value;
        }
    }
}