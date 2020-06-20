class Node {
    public Node next;
    public int val;
    
    public Node(Node n, int v) {
        next = n;
        val = v;
    }
}

class MyLinkedList {
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    private Node getNode(int index) {
        if(index < 0) return null;
        int i = 0;
        Node curr = head;
        while(curr != null && i < index) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    private Node getTail() {
        Node curr = head;
        while(curr != null && curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node n = getNode(index);
        return n == null?-1:n.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        head = new Node(head,val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }
        Node tail = getTail();
        tail.next = new Node(null, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node prev = getNode(index - 1);
        if(prev != null) prev.next = new Node(prev.next, val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node curr = getNode(index);
        if (curr == null) {
            return;
        }
        Node prev = getNode(index - 1);
        if(prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

 public class Main {
     public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        obj.get(1);
        obj.deleteAtIndex(0);
        obj.get(0);
     }
 }