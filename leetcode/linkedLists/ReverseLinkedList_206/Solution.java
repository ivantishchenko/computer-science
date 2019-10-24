class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currentElement = head;
        ListNode prevElement = null;
        while (currentElement != null) {
            ListNode nextElement = currentElement.next;
            currentElement.next = prevElement;
            prevElement = currentElement;
            currentElement = nextElement;
        }
        return prevElement;
    }
}