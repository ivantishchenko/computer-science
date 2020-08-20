# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder, postorder):
        if not inorder:
            return None

        root_val = postorder.pop()
        root_idx = inorder.index(root_val)

        root = TreeNode(root_val)
        root.right = self.buildTree(inorder[root_idx + 1:], postorder)
        root.left = self.buildTree(inorder[:root_idx], postorder)
        return root

    def buildTree_slow(self, inorder, postorder):
        if not inorder:
            return None

        # find root
        inorder_map = {}
        for i in range(len(inorder)):
            inorder_map[inorder[i]] = i

        root_idx = -1
        for post_el in reversed(postorder):
            if post_el in inorder_map:
                root_idx = inorder_map[post_el]
                break

        root = TreeNode(post_el)
        root.left = self.buildTree(inorder[:root_idx], postorder)
        root.right = self.buildTree(inorder[root_idx + 1:], postorder)
        return root

a = Solution()
a.buildTree([9,3,15,20,7], [9,15,7,20,3])
pass