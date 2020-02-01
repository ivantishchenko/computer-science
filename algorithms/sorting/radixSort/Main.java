// https://www.baeldung.com/java-radix-sort
// Time: O(d * (n + b))
// Space: O(n + b)
// n is the number of elements
// b base range all digits are [0, b)
// d number of digits
import java.util.*;

class RadixSort {

    private int[] countingSort(int[] arr, int exp) {
        int count[] = new int[10];
        Arrays.fill(count, 0);
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        return output;
    }

    public int[] sort(int[] arr) {
        // find the maximum
        int max = Arrays.stream(arr).max().getAsInt();
        // iterate # of times as digits in max
        for (int exp = 1; max / exp > 0; exp *= 10) {
            arr = countingSort(arr, exp);
        }
        return arr;
    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {387, 468, 134, 123, 68, 221, 769, 37, 7};
        RadixSort s = new RadixSort();
        arr = s.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
