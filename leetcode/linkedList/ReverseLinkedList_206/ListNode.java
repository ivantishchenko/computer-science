public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            String nodeStr = current.next == null?
                    String.valueOf(current.val) :current.val + " -> ";
            sb.append(nodeStr);
            current = current.next;
        }
        return sb.toString();
    }
}