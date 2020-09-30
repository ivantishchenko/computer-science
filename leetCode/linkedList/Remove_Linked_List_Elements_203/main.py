# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        tmp = ListNode(0)
        tmp.next = head

        pointer = tmp
        while pointer.next:
            if pointer.next.val == val:
                pointer.next = pointer.next.next
            else:
                pointer = pointer.next

        return tmp.next
