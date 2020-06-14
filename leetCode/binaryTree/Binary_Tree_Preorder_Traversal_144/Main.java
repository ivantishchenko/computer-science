import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class PreOrderTraversal {
    /*
    * Pre-order traversal is to visit the root first.
    * Then traverse the left subtree.
    * Finally, traverse the right subtree.
    * 
    * Uses of Preorder
    * Preorder traversal is used to create a copy of the tree.
    * Preorder traversal is also used to get prefix expression on of an expression tree.
    * Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
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
    public void preorderTraversalRecursive(TreeNode root, List<Integer> nodes) {
        if(root == null) {
            return;
        }
        nodes.add(root.val);
        preorderTraversal(root.left, nodes);
        preorderTraversal(root.right, nodes);
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        preorderTraversal(root, nodes);
        return nodes;
    }

    /*
    * There are several iterative solutions for tree traversal.
    * One of the solutions is to use a stack to simulate the recursion process. 
    * 
    * Uses of Preorder
    * Preorder traversal is used to create a copy of the tree.
    * Preorder traversal is also used to get prefix expression on of an expression tree.
    * Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
    * 
    * Time Complexity.
    * O(N),
    * because we visit each node exactly once.
    * And the depth of the tree might be N in the worst case.
    * It is comparatively easy to do traversal recursively
    * but when the depth of the tree is too large,
    * we might suffer from `stack overflow` problem.
    * That's one of the main reasons why we want to solve this problem iteratively sometimes. 
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
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        if(root != null) {
            nodeStack.push(root);
        }
        TreeNode currNode;
        while(!nodeStack.isEmpty()) {
            currNode = nodeStack.pop();

            nodes.add(currNode.val);

            if(currNode.right != null) {
                nodeStack.push(currNode.right);
            }
            if(currNode.left != null) {
                nodeStack.push(currNode.left);
            }
        }
        return nodes;
    }

}