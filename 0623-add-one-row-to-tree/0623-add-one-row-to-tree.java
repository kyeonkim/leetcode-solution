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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val, root, null);
            return newNode;
        }
        addOne(root, val, depth, 2);
        return root;
    }

    public void addOne(TreeNode root, int val, int depth, int curDepth) {
        if (curDepth == depth) {
            TreeNode newNodeLeft = new TreeNode(val, root.left, null);
            TreeNode newNodeRight = new TreeNode(val, null, root.right);
            root.left = newNodeLeft;
            root.right = newNodeRight;
            return ;
        }
        if (root.left != null)
            addOne(root.left, val, depth, curDepth + 1);
        if (root.right != null)
            addOne(root.right, val, depth, curDepth + 1);
    }
}