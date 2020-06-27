/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsIter(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        ListNode a = l1;
        ListNode b = l2;
        if(a.val < b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        ListNode prevNode = head;
        while(a != null && b != null) {
            if(a.val < b.val) {
                prevNode.next = a;    
                a = a.next;
            } else {
                prevNode.next = b;       
                b = b.next;
            }
            prevNode = prevNode.next;
        }
        while(b != null) {
            prevNode.next = b;
            b = b.next;
            prevNode = prevNode.next;
        }
        while(a != null) {
            prevNode.next = a;
            a = a.next;
            prevNode = prevNode.next;
        }
        prevNode.next = null;
        return head;
    }
}