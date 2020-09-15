# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__eq__ = lambda self, other: self.val == other.val
        ListNode.__lt__ = lambda self, other: self.val < other.val

        curr = head = ListNode(0)
        min_pq = []
        for node in lists:
            if node:
                heappush(min_pq, (node.val, node))

        while min_pq:
            val, node = heappop(min_pq)
            curr.next = ListNode(val)
            curr = curr.next
            node = node.next
            if node:
                heappush(min_pq, (node.val, node))

        return head.next

    # def mergeKLists(self, lists: List[ListNode]) -> ListNode:
    #     def is_elements_left():
    #         for node in lists:
    #             if node:
    #                 return True
    #
    #         return False
    #
    #     min_heap = []
    #     res = []
    #
    #     k = len(lists)
    #
    #     while is_elements_left():
    #         for i in range(k):
    #             if lists[i] is not None:
    #                 heapq.heappush(min_heap, lists[i].val)
    #                 if len(min_heap) > k + 1:
    #                     res.append(heapq.heappop(min_heap))
    #                 lists[i] = lists[i].next
    #
    #     while min_heap:
    #         res.append(heapq.heappop(min_heap))
    #
    #     if not res:
    #         return None
    #
    #     head = ListNode()
    #     head.val = res[0]
    #
    #     prev_node = head
    #     for i in range(1, len(res)):
    #         curr_node = ListNode()
    #         curr_node.val = res[i]
    #         prev_node.next = curr_node
    #         prev_node = curr_node
    #
    #     return head
