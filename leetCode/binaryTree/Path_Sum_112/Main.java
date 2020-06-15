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
    public boolean hasPathSum(TreeNode root, int acc, int target) {
        if(root == null) {
            return false;
        }
        acc += root.val;

        if(root.left == null && root.right == null) {
            if(acc == target) {
                return true;
            }
        }

        if(hasPathSum(root.left, acc, target)) {
            return true;
        }

        if(hasPathSum(root.right, acc, target)) {
            return true;
        }

        return false;
    } 

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }

    public boolean hasPathSumImproved(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val); 
    }

}