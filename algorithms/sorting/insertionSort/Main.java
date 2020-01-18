// Worst O(n^2), Best O(n), Average O(n^2)
class InsertionSort {
    public void sort(int[] arr) {
        int j, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i;
            while(j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            } 
            arr[j] = key;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {25, 17, 31, 13, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        InsertionSort s = new InsertionSort();
        s.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
