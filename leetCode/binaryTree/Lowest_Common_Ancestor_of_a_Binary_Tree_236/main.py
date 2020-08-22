# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.res = None

    def get_path(self, root, node_val):
        if not root:
            return []

        if root.val == node_val:
            return [root.val]

        left = self.get_path(root.left, node_val)
        if left:
            return [root.val] + left

        right = self.get_path(root.right, node_val)
        if right:
            return [root.val] + right

        return []

    def lowestCommonAncestorAlt(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # retain path to p
        path_p = self.get_path(root, p.val)
        # retain path to q
        path_q = self.get_path(root, q.val)
        # find an intersection

        inter = list(set(path_p) & set(path_q))

        return inter[-1]

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        if root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            # LCA is middle
            return root
        else:
            # LCA is one of the nodes
            return left if left else right


