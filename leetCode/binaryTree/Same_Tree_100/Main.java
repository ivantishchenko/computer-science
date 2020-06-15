import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(p);
        nodes.offer(q);
        while(!nodes.isEmpty()) {
            TreeNode n1 = nodes.poll();
            TreeNode n2 = nodes.poll();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null) return false;
            if(n1.val != n2.val) return false;
            nodes.offer(n1.left);
            nodes.offer(n2.left);
            nodes.offer(n1.right);
            nodes.offer(n2.right);
        }
        return true;
    }
}