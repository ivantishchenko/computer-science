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
class InOrderTraversal {
    // good explanation - https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/
    /**
     * In-order traversal is to traverse the left subtree first.
     * Then visit the root. Finally, traverse the right subtree.
     * Typically, for binary search tree, we can retrieve all
     * the data in sorted order using in-order traversal.
     * 
     * Uses of Inorder
     * In case of binary search trees (BST),
     * Inorder traversal gives nodes in non-decreasing order.
     * To get nodes of BST in non-increasing order,
     * a variation of Inorder traversal where Inorder itraversal s reversed, can be used.
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
     * Definition for a binary tree node:
     * public class TreeNode {
     *     number val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(number x) { val = x; }
     * }
     * 
     */

    public void inorderTraversalRecursive(TreeNode root, List<Integer> nodes) {
        if(root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return nodes;
    }

    // good explanation - https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
    // Morris Traversal:
    // https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/, 
    // https://www.youtube.com/watch?v=YA-nB2wjVcI&feature=youtu.be&t=11m42s

    /**
     * In-order traversal is to traverse the left subtree first.
     * Then visit the root. Finally, traverse the right subtree.
     * Typically, for binary search tree, we can retrieve all
     * the data in sorted order using in-order traversal.
     * 
     * Uses of Inorder
     * In case of binary search trees (BST),
     * Inorder traversal gives nodes in non-decreasing order.
     * To get nodes of BST in non-increasing order,
     * a variation of Inorder traversal where Inorder itraversal s reversed, can be used.
     * 
     * Time Complexity.
     * O(N),
     * because we visit each node exactly once.
     * And the depth of the tree might be N in the worst case.
     * 
     * Space Complexity.
     * O(N),
     * since in the worst case, we will have all the nodes in the stack.
     * There are some other solutions (Morris Traversal) for iterative traversal
     * which can reduce the space complexity to O(1).
     * 
     * Definition for a binary tree node:
     * public class TreeNode {
     *     number val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(number x) { val = x; }
     * }
     */

    public List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !nodeStack.isEmpty()) {
            // the next node to be visited is the leftmost
            while(curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            nodeList.add(curr.val);
            curr = curr.right;
        }
        return nodeList;
    }
}