# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        # Level traversal of a tree
        q = deque([root])
        res = ""
        while q:
            curr = q.popleft()
            if curr:
                res += str(curr.val) + ','
                q.append(curr.left)
                q.append(curr.right)
            else:
                res += '#,'

        return res[:-1]

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        node_array = [int(c) if c != '#' else c for c in data.split(',')]

        if node_array[0] == '#':
            return None

        root_node = TreeNode(node_array[0])
        q = deque([root_node])
        curr_idx = 1
        while q:
            curr_node = q.popleft()
            if node_array[curr_idx] != '#':
                curr_node.left = TreeNode(node_array[curr_idx])
                q.append(curr_node.left)
            curr_idx += 1

            if node_array[curr_idx] != '#':
                curr_node.right = TreeNode(node_array[curr_idx])
                q.append(curr_node.right)
            curr_idx += 1

        return root_node

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))