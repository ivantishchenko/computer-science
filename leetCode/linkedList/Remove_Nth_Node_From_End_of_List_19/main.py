# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        tmp = ListNode(0)
        tmp.next = head

        pointer = tmp
        list_len = 0
        while pointer:
            pointer = pointer.next
            list_len += 1

        pointer = tmp
        list_len -= n
        for _ in range(list_len):
            pointer = pointer.next

        pointer.next = pointer.next.next
        return tmp.next



    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        res = ListNode(0)
        res.next = head

        slow_node = res
        fast_node = res
        for _ in range(n + 1):
            fast_node = fast_node.next

        while fast_node:
            fast_node = fast_node.next
            slow_node = slow_node.next

        slow_node.next = slow_node.next.next
        return res.next
