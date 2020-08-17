# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        next_node = root
        while stack or next_node:
            while next_node:
                stack.append(next_node)
                next_node = next_node.left

            next_node = stack.pop()
            res.append(next_node.val)
            next_node = next_node.right

        return res
