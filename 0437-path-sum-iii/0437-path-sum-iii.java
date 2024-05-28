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
    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        recursionStart(root, targetSum);
        return count;
    }

    private void recursionStart(TreeNode root, int targetSum) {
        if (root == null) return;
        dfs(root, 0, targetSum);
        recursionStart(root.left, targetSum);
        recursionStart(root.right, targetSum);
    }

    private void dfs(TreeNode root, long currSum, int targetSum) {
        if (root == null) return;
        currSum += root.val;
        if (targetSum == currSum)
            count++;
        dfs(root.left, currSum, targetSum);
        dfs(root.right, currSum, targetSum);
    }
}