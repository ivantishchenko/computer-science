import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

class MyHashMap {
    private static final int MAX_SIZE = 100000;
    private ArrayList<ArrayList<KeyVal>> bucketArray;

    class KeyVal {
        public int k;
        public int v;
    
        public KeyVal(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        bucketArray = new ArrayList<>(Collections.nCopies(MAX_SIZE, null));
    }

    // weak hash function
    private int getIndex(int key) {
        return key % MAX_SIZE;
    }

    // search the key in a bucket return -1 if doesn't exist
    private int searchBucket(int index, int key) {
        ArrayList<KeyVal> bucket = bucketArray.get(index);
        if(bucket == null) return -1;
        for (int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).k == key) return i;
        }
        return -1;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        int position = searchBucket(index, key);

        if(position == -1) {
            if(bucketArray.get(index) == null) {
                bucketArray.set(index, new ArrayList<>());
            }
            bucketArray.get(index).add(new KeyVal(key, value));
        } else {
            bucketArray.get(index).set(position, new KeyVal(key, value));
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        int position = searchBucket(index, key);
        if(position == -1) {
            return position;
        } else {
            return bucketArray.get(index).get(position).v;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        int position = searchBucket(index, key);

        if(position != -1) {
            bucketArray.get(index).remove(position);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

public class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);          
        hashMap.put(2, 2);         
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1 
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found) 
    }
}