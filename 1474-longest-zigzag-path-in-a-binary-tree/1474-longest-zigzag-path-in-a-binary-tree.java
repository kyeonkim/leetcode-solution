/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxLen;

    public int longestZigZag(TreeNode root) {
        maxLen = 0;
        dfs(root, 0, 0);
        return maxLen;
    }

    private void dfs(TreeNode root, int l, int r) {
        if (root == null) return;
        maxLen = Math.max(maxLen, l);
        maxLen = Math.max(maxLen, r);
        dfs(root.left, 0, l + 1);
        dfs(root.right, r + 1, 0);
    }
}