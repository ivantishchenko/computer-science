// https://www.baeldung.com/java-counting-sort
// Time: O(n + k) where
// Space: O(n + k) where
// n is the number of elements
// k is the range of input i.e. all numbers are [0, k]
import java.util.*;

class CountingSort {
    public int[] sort(int[] arr) {
        int k = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[k + 1];
        Arrays.fill(count, 0);
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++; 
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return output;
    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5};
        CountingSort s = new CountingSort();
        arr = s.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
