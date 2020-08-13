# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, start, end, memo):
        if start > end:
            return [None]
        if (start, end) in memo:
            memo[(start, end)]
        res = []
        for i in range(start, end + 1):
            left_list = self.helper(start, i - 1, memo)
            right_list = self.helper(i + 1, end, memo)

            for left_node in left_list:
                for right_node in right_list:
                    tree = TreeNode(i, left_node, right_node)
                    res.append(tree)

        memo[(start, end)] = res
        return memo[(start, end)]


    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        memo = {}
        return self.helper(1, n, memo)