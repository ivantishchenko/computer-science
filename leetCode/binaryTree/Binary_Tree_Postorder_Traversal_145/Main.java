import java.util.List;
import java.util.Stack;

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
class PostOrderTraversal {
    // good explanation - https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/

    /**
     * Post-order traversal is to traverse the left subtree first.
     * Then traverse the right subtree. Finally, visit the root.
     * 
     * It is worth noting that when you delete nodes in a tree,
     * deletion process will be in post-order. That is to say,
     * when you delete a node, you will delete its left child
     * and its right child before you delete the node itself.
     * Also, post-order is widely use in mathematical expression.
     * It is easier to write a program to parse a post-order expression.
     * 
     * Uses of Postorder
     * Postorder traversal is used to delete the tree.
     * Postorder traversal is also useful to get the postfix expression of an expression tree.
     * Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.
     * 
     * Time Complexity.
     * O(N),
     * because we visit each node exactly once.
     * And the depth of the tree might be N in the worst case.
     * The level of recursion might be at most N in the worst case.
     * Therefore, taking system stack into consideration,
     * the Space Complexity is O(N) as well.
     * The complexity might be different due to a different implementation.
     * It is comparatively easy to do traversal recursively
     * but when the depth of the tree is too large,
     * we might suffer from `stack overflow` problem.
     * That's one of the main reasons why we want to solve this problem iteratively sometimes.
     * 
     */

    public void postorderTraversalRecursive(TreeNode root, List<Integer> nodes) {
        if(root == null) {
            return;
        }
        postorderTraversal(root.left, nodes);
        postorderTraversal(root.right, nodes);
        nodes.add(root.val);
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    // good explanation (two stacks) - https://www.geeksforgeeks.org/iterative-postorder-traversal/

    /**
     * Post-order traversal is to traverse the left subtree first.
     * Then traverse the right subtree. Finally, visit the root.
     * 
     * Uses of Postorder
     * Postorder traversal is used to delete the tree.
     * Postorder traversal is also useful to get the postfix expression of an expression tree.
     * Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.
     * 
     * Time Complexity.
     * O(N),
     * because we visit each node exactly once.
     * And the depth of the tree might be N in the worst case.
     * 
     * Space Complexity.
     * O(N),
     * since in the worst case, we will have all the nodes in stacks.
     * There are some other solutions (Morris Traversal) for iterative traversal
     * which can reduce the space complexity to O(1).
     * 
     */
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        Stack<Integer> finalStack = new Stack<>();

        if(root != null) {
            tmpStack.push(root);
        }

        while(!tmpStack.isEmpty()) {
            TreeNode curr = tmpStack.pop();
            finalStack.push(curr.val);
            if(curr.left != null) {
                tmpStack.push(curr.left);
            }
            if(curr.right != null) {
                tmpStack.push(curr.right);
            }
        }

        while(!finalStack.isEmpty()) {
            res.add(finalStack.pop());
        }

        return res;
    }

}