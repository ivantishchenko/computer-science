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
    private int height;
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int hLeft = maxDepth(root.left);
        int hRight= maxDepth(root.right);
        return Math.max(hLeft, hRight) + 1;
    }
}