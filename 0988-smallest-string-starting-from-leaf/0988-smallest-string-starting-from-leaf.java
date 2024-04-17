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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder answer = new StringBuilder();
        return findSmallestLeaf(root, answer);
    }

    public String findSmallestLeaf(TreeNode root, StringBuilder answer) {
        if (root == null) return "";
        answer.append((char)('a' + root.val));
        if (root.left == null && root.right == null)
            return answer.reverse().toString();
        String leftStr = "", rightStr = "";
        if (root.left != null)
            leftStr = findSmallestLeaf(root.left, new StringBuilder(answer));
        if (root.right != null)
            rightStr = findSmallestLeaf(root.right, new StringBuilder(answer));
        if (leftStr.isEmpty()) 
            return rightStr;
        if (rightStr.isEmpty()) 
            return leftStr;
        return leftStr.compareTo(rightStr) < 0 ? leftStr : rightStr;
    }
}