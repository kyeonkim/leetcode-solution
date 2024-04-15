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
    public int sumNumbers(TreeNode root) {
        return sumNumber(root, 0);
    }

    public int sumNumber(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null & root.right == null)
            return sum + root.val;
        sum += root.val;
        return sumNumber(root.left, sum * 10) + sumNumber(root.right, sum * 10);
    }
}