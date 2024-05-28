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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        dfs(root1, result1);
        dfs(root2, result2);
        if (result1.size() != result2.size())
            return false;
        for (int i = 0; i < result1.size(); i++) {
            int x = result1.get(i), y = result2.get(i);
            if (x != y)
                return false;
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root.left == null && root.right == null)
            result.add(root.val);
        if (root.left != null)
            dfs(root.left, result);
        if (root.right != null)
            dfs(root.right, result);
    }
}