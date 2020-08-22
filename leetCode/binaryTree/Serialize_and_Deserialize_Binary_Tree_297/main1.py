# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import pickle


"""

Only works with unique trees

"""

class Codec:
    def traverse_post(self, root):
        if not root:
            return []

        left = self.traverse_post(root.left)
        right = self.traverse_post(root.right)

        return left + right + [root.val]

    def traverse_in(self, root):
        if not root:
            return []

        left = self.traverse_in(root.left)
        right = self.traverse_in(root.right)

        return left + [root.val] + right

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        # get postorder
        post_order = self.traverse_post(root)
        # get inorder
        in_order = self.traverse_in(root)
        # concat
        print(post_order)
        print(in_order)
        return pickle.dumps(post_order + in_order)

    def build_tree(self, inorder, postorder):
        if not inorder:
            return None

        root_val = postorder.pop()
        root_idx = inorder.index(root_val)

        root = TreeNode(root_val)
        root.right = self.build_tree(inorder[root_idx + 1:], postorder)
        root.left = self.build_tree(inorder[:root_idx], postorder)
        return root

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        encode_list = pickle.loads(data)
        # print(encode_list)
        post_order = encode_list[:len(encode_list)//2]
        in_order = encode_list[len(encode_list)//2:]
        print(post_order)
        print(in_order)
        # reconstruct a tree from preorder and postorder
        root = self.build_tree(in_order, post_order)
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))