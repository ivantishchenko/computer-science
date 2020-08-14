"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    visited = {}
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        if node in self.visited:
            return self.visited[node]

        new_node = Node(node.val, [])
        self.visited[node] = new_node
        for v in node.neighbors:
            new_node.neighbors.append(self.cloneGraph(v))
        return new_node
