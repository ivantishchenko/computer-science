
public class Main {

    public static final int N = 15;

    public static void main(String[] args) {
        ListNode currentNode = new ListNode(N);
        currentNode.next = null;
        for (int i = N - 1; i > 0; i--) {
            ListNode newNode = new ListNode(i);
            newNode.next = currentNode;
            currentNode = newNode;
        }

        System.out.println(currentNode);

        Solution solution = new Solution();
        ListNode revNode = solution.reverseList(currentNode);
        System.out.println(revNode);
    }
}
