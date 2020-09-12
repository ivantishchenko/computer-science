# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        q = deque()
        if root:
            q.append(root)

        res = []
        while q:
            q_size = len(q)
            level = []
            for _ in range(q_size):
                curr = q.popleft()

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

                level.append(curr.val)
            res.append(level)
        return res
