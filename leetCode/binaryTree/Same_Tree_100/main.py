# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def isSameTree_rec(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        return p.val == q.val and self.isSameTree_rec(p.left, q.left) and self.isSameTree_rec(p.right, q.right)

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        nodes = deque()
        if p and q:
            nodes.append(p)
            nodes.append(q)
        elif p or q:
            return False

        while nodes:
            curr_p = nodes.popleft()
            curr_q = nodes.popleft()

            if curr_p.val != curr_q.val:
                return False

            if curr_p.left and curr_q.left:
                nodes.append(curr_p.left)
                nodes.append(curr_q.left)
            elif curr_p.left or curr_q.left:
                return False

            if curr_p.right and curr_q.right:
                nodes.append(curr_p.right)
                nodes.append(curr_q.right)
            elif curr_p.right or curr_q.right:
                return False

        return True
