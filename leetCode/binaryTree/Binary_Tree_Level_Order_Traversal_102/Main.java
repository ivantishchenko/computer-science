import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

// good explanation - https://www.geeksforgeeks.org/?p=2686

/**
 * Time Complexity.
 * O(N),
 * since each node in the tree will be pushed into the queue exactly once,
 * where N is the total number of nodes in the tree.
 * 
 * Space Complexity.
 * O(N),
 * the size of the queue will be at most N because
 * each node will be pushed into the queue exactly once.
 * 
 */

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if(root != null) {
            nodeQueue.offer(root);
        }
        while(!nodeQueue.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int queueSize = nodeQueue.size();

            for(int i = 0; i < queueSize; i++) {
                TreeNode curr = nodeQueue.poll();
                levelList.add(curr.val);
                if(curr.left != null) {
                    nodeQueue.offer(curr.left);
                }
                if(curr.right != null) {
                    nodeQueue.offer(curr.right);
                }
            }
            // build res
            res.add(levelList);
        }
        return res;
    }
}