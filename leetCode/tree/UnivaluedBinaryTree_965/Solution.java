import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    private Set<Integer> uniqueValues = new HashSet<>();

    private void dfsTree(TreeNode root) {
        if(root != null) {
            uniqueValues.add(root.val);
            dfsTree(root.right);
            dfsTree(root.left);
        }
    }

    // go down from top to bottom
    public boolean isUnivalTreeDFS(TreeNode root) {
        dfsTree(root);
        return uniqueValues.size() == 1;
    }

    // go over all nodes in a level
    public boolean isUnivalTreeBFS(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            uniqueValues.add(node.val);
            if(uniqueValues.size() > 1) return false;
            if (node.left != null) nodes.add(node.left);
            if (node.right!= null) nodes.add(node.right);
        }
        return true;
    }

    // A tree is univalued if both its children are univalued,
    // plus the root node has the same value as the child nodes.
    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }

}