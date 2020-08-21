"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution:
    def connect(self, root):
        if root:
            scanner = root.next

            # find left most node on the right side
            while scanner:
                if scanner.left:
                    scanner = scanner.left
                    break
                if scanner.right:
                    scanner = scanner.right
                    break
                scanner = scanner.next

            if root.right:
                root.right.next = scanner

            if root.left:
                root.left.next = root.right if root.right else scanner

            self.connect(root.left)
            self.connect(root.right)



        return root
