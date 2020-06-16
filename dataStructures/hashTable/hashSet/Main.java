import java.sql.Array;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class MyHashSet {
    private static final int MAX_SIZE = 100000;
    private ArrayList<ArrayList<Integer>> bucketArray;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketArray = new ArrayList<>(Collections.nCopies(MAX_SIZE, null));
    }

    // weak hash function
    private int getIndex(int key) {
        return key % MAX_SIZE;
    }

    // search the key in a bucket return -1 if doesn't exist
    private int searchBucket(int index, int key) {
        ArrayList<Integer> bucket = bucketArray.get(index);
        if(bucket == null) return -1;
        for (int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i) == key) return i;
        }
        return -1;
    }

    public void add(int key) {
        int index = getIndex(key);
        int position = searchBucket(index, key);

        if(position == -1) {
            if(bucketArray.get(index) == null) {
                bucketArray.set(index, new ArrayList<>());
            }
            bucketArray.get(index).add(key);
        }
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        int position = searchBucket(index, key);

        if(position != -1) {
            bucketArray.get(index).remove(position);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        int position = searchBucket(index, key);
        return position != -1; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class Main {
    public static void main(String[] args) {
        MyHashSet s = new MyHashSet();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(2);
        s.remove(2);
        System.out.println(s.contains(1));
        System.out.println(s.contains(2));
        System.out.println(s.contains(3));
    }
}