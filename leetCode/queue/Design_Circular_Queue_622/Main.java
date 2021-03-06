import java.util.List;
import java.util.ArrayList;


class MyCircularQueueMaster {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueueMaster(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}

class MyCircularQueue {
    private int qSize;
    private Integer[] data;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        qSize = k;
        data = new Integer[qSize];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % qSize;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        data[head] = null;
        head = (head + 1) % qSize;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return data[Math.floorMod(head, qSize)];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return data[Math.floorMod(tail - 1, qSize)];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return tail == head && data[tail] == null;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return tail == head && data[tail] != null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

public class Main {

    public static void main(String[] args) {
        var q = new MyCircularQueueMaster(3);
        boolean test;
        int val;
        test = q.enQueue(1); 
        test = q.enQueue(2); 
        test = q.enQueue(3); 
        test = q.deQueue();
        test = q.deQueue();  
        test = q.deQueue();
        // test = q.enQueue(3); 
        // test = q.enQueue(4); 
        val = q.Rear();  
        val = q.Front();
        test = q.deQueue();
        test = q.deQueue();  
        test = q.deQueue();
        val = q.Front();
        val = q.Front();
    }
}